package al.viki.ui.home

import al.bruno.adapter.OnClickListener
import al.bruno.adapter.PagedListAdapter
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.R
import al.viki.authentication.NotifyAuthenticationChange
import al.viki.common.collectLatestFlow
import al.viki.common.diffUtil
import al.viki.databinding.FragmentHomeBinding
import al.viki.databinding.PropertiesItemBinding
import al.viki.model.PropertyUi
import al.viki.ui.details.DetailsPropertyFragment
import al.viki.ui.details.DetailsPropertyFragmentArgs
import android.content.Context
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.MenuCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private var notifyAuthenticationChange: NotifyAuthenticationChange? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val adapter by lazy {
        PagedListAdapter<PropertyResponse, PropertiesItemBinding>(
            R.layout.properties_item, { t, vm ->
                vm.property = t
                vm.onClick = object : OnClickListener<PropertyResponse> {
                    override fun onClick(view: View, t: PropertyResponse) {
                        findNavController()
                            .navigate(
                                HomeFragmentDirections.actionHomeFragmentToDetailsPropertyFragment(PropertyUi.toPropertyUi(t))
                            )
                    }
                }
            },
            diffUtil
        )
    }

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collectLatestFlow(homeViewModel.collectionPagedList()) {
            adapter.submitData(it)
        }
        binding?.property?.adapter = adapter
        binding?.menu?.setOnClickListener {
            showMenu(it, R.menu.menu_home)
        }
        binding?.refreshProperty?.setOnRefreshListener {
            collectLatestFlow(homeViewModel.collectionPagedList()) {
                adapter.submitData(it)
            }
            binding?.refreshProperty?.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(v.context, v)
        popup.menuInflater.inflate(menuRes, popup.menu)
        if (popup.menu is MenuBuilder) {
            val menuBuilder = popup.menu as MenuBuilder
            MenuCompat.setGroupDividerEnabled(menuBuilder, true)
            menuBuilder.setOptionalIconsVisible(true)
            for (item in menuBuilder.visibleItems) {
                if(item.itemId == R.id.menu_profile) {
                    item.title = "Bruno Dushi"
                }
                val iconMarginPx =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 4.toFloat(), resources.displayMetrics)
                        .toInt()
                if (item.icon != null) {
                    item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx,0)
                }
            }
        }
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_new_property -> {
                    findNavController().navigate(R.id.action_homeFragment_to_newPropertyFragment)
                    true
                }
                R.id.menu_logout -> {
                    notifyAuthenticationChange?.onSignOut()
                    true
                }
                R.id.menu_new_request -> {
                    findNavController().navigate(R.id.action_homeFragment_to_newRequestFragment)
                    true
                }
                R.id.menu_profile -> {
                    findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
                    true
                }
                else -> {
                    true
                }
            }
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        // Show the popup menu.
        popup.show()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is NotifyAuthenticationChange -> notifyAuthenticationChange = context
            else -> throw RuntimeException("$context must implement NotifyLanguageChange")
        }
    }
}