package al.viki.ui.home

import al.bruno.adapter.DropDownAdapter
import al.bruno.adapter.LoadStateAdapter
import al.bruno.adapter.OnClickListener
import al.bruno.adapter.PagedListAdapter
import al.bruno.core.State
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.R
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.collectLatestFlow
import al.viki.common.propertiesDiffUtil
import al.viki.common.requestDiffUtil
import al.viki.databinding.*
import al.viki.model.PropertyTypeUi
import al.viki.model.PropertyUi
import android.content.Context
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.MenuCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var properties = true
    private var _binding: FragmentHomeBinding? = null
    private var notifyAuthenticationChange: NotifyAuthenticationChange? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val propertiesLoadStateAdapter = LoadStateAdapter<LoadStateFooterViewItemBinding>(R.layout.load_state_footer_view_item) { loadState, vm ->
        vm.loadState = loadState
        vm.onClick = View.OnClickListener {
            propertiesAdapter.retry()
        }
    }
    private val requestsLoadStateAdapter = LoadStateAdapter<LoadStateFooterViewItemBinding>(R.layout.load_state_footer_view_item) { loadState, vm ->
        vm.loadState = loadState
        vm.onClick = View.OnClickListener {
            requestsAdapter.retry()
        }
    }
    private val propertiesAdapter by lazy {
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
            propertiesDiffUtil
        )
    }

    private val requestsAdapter by lazy {
        PagedListAdapter<RequestResponse, RequestItemBinding>(
            R.layout.request_item, { t, vm ->
                vm.request = t
                vm.onClick = object : OnClickListener<RequestResponse> {
                    override fun onClick(view: View, t: RequestResponse) {
                        Toast.makeText(requireContext(), "TODO", Toast.LENGTH_SHORT).show()
                    }
                }
            },
            requestDiffUtil
        )
    }

    private val propertyTypeAdapter by lazy {
        DropDownAdapter<PropertyTypeUi, DropDownItemFilterBinding>(R.layout.drop_down_item_filter) { t, vm ->
            vm.selection = t
        }
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
        binding?.operationFilter?.adapter = propertyTypeAdapter
        binding?.property?.adapter = propertiesAdapter
        binding?.menu?.setOnClickListener {
            showMenu(it, R.menu.menu_home)
        }
        binding?.label?.setOnClickListener {
            switchView(it)
        }

        binding?.refreshProperty?.setOnRefreshListener {
            if(properties) {
                collectLatestFlow(homeViewModel.propertiesCollectionPagedList()) {
                    propertiesAdapter.submitData(it)
                }
            } else {
                collectLatestFlow(homeViewModel.requestCollectionPagedList()) {
                    requestsAdapter.submitData(it)
                }
            }
            binding?.refreshProperty?.isRefreshing = false
        }

        collectLatestFlow(homeViewModel.propertiesCollectionPagedList()) {
            propertiesAdapter.submitData(it)
        }

        collectLatestFlow(homeViewModel.requestCollectionPagedList()) {
            requestsAdapter.submitData(it)
        }

        collectLatestFlow(homeViewModel.propertyTypes) {
            when (it) {
                is State.Success -> {
                    it.t?.let { items -> propertyTypeAdapter.setItem(items) }
                }
                is State.Error -> {}
                is State.Unauthorized -> {}
                is State.Loading -> {}
            }
        }
    }

    private fun switchView(view: View) {
        properties = !properties
        if(properties) {
            (view as MaterialTextView).setText(R.string.properties)
            binding?.property?.adapter = propertiesAdapter
                .withLoadStateFooter(
                    footer = propertiesLoadStateAdapter
                )
        } else {
            (view as MaterialTextView).setText(R.string.requests)
            binding?.property?.adapter = requestsAdapter
                .withLoadStateFooter(
                    footer = requestsLoadStateAdapter
                )
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
                    item.title = "John Doo"
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