package al.viki.ui.home

import al.bruno.adapter.*
import al.bruno.core.State
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.BuildConfig
import al.viki.R
import al.viki.authentication.auth.NotifyAuthenticationChange
import al.viki.common.hideSoftKeyBoard
import al.viki.common.propertiesDiffUtil
import al.viki.common.requestDiffUtil
import al.viki.databinding.*
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.FilterUi
import al.viki.model.UserUi
import al.viki.ui.filter.FilterDialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.annotation.MenuRes
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.MenuCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var userUi: UserUi? = null
    private var filterUi = FilterUi()
    private var _binding: FragmentHomeBinding? = null
    private var notifyAuthenticationChange: NotifyAuthenticationChange? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private val propertiesLoadStateAdapter =
        LoadStateAdapter<LoadStateFooterViewItemBinding>(R.layout.load_state_footer_view_item) { loadState, vm ->
            vm.loadState = loadState
            vm.onClick = View.OnClickListener {
                propertiesAdapter.retry()
            }
        }

    private val propertiesAdapter by lazy {
        PagedListAdapter<PropertiesResponse, PropertiesItemBinding>(
            R.layout.properties_item, { t, vm ->
                vm.properties = t
                vm.onClick = object : OnClickListener<PropertiesResponse> {
                    override fun onClick(view: View, t: PropertiesResponse) {
                        when (view.id) {
                            R.id.properties_item ->
                                if (t.isRequest()) {
                                    findNavController()
                                        .navigate(
                                            HomeFragmentDirections
                                                .actionHomeFragmentToRequestDetailsFragment(t.id)
                                        )
                                } else {
                                    findNavController()
                                        .navigate(
                                            HomeFragmentDirections
                                                .actionHomeFragmentToPropertyDetailsFragment(t.id)
                                        )
                                }
                            R.id.properties_share_item -> {
                                val sendIntent: Intent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(
                                        Intent.EXTRA_TEXT,
                                        "${BuildConfig.HOST_NAME}property/${t.id}"
                                    )
                                    type = "text/plain"
                                }
                                startActivity(
                                    Intent.createChooser(
                                        sendIntent,
                                        getString(R.string.app_name)
                                    )
                                )
                            }
                            R.id.properties_delete_item ->
                                if(t.isRequest()) {
                                    MaterialAlertDialogBuilder(requireContext())
                                        .setIcon(al.viki.foundation.R.drawable.ic_outline_warning_amber)
                                        .setTitle(R.string.delete_property_title)
                                        .setMessage(getString(R.string.delete_messages, t.title))
                                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                                            homeViewModel.deleteProperty(t.id)
                                            dialogInterface.dismiss()
                                        }
                                        .setNegativeButton(R.string.cancel_title) { dialogInterface, _ ->
                                            dialogInterface.dismiss()
                                        }
                                        .setCancelable(false)
                                        .show()
                                } else {
                                    MaterialAlertDialogBuilder(requireContext())
                                        .setIcon(al.viki.foundation.R.drawable.ic_outline_warning_amber)
                                        .setTitle(R.string.delete_property_title)
                                        .setMessage(getString(R.string.delete_messages, t.title))
                                        .setPositiveButton(R.string.ok_title) { dialogInterface, _ ->
                                            homeViewModel.deleteProperty(t.id)
                                            dialogInterface.dismiss()
                                        }
                                        .setNegativeButton(R.string.cancel_title) { dialogInterface, _ ->
                                            dialogInterface.dismiss()
                                        }
                                        .setCancelable(false)
                                        .show()
                                }
                        }
                    }
                }
            },
            propertiesDiffUtil
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
        binding?.property?.adapter = propertiesAdapter
            .withLoadStateFooter(
                footer = propertiesLoadStateAdapter
            )
        binding?.menu?.setOnClickListener {
            showMenu(it, R.menu.menu_home)
        }
        binding?.mapView?.setOnClickListener {
            findNavController()
                .navigate(
                    HomeFragmentDirections.actionHomeFragmentToMapViewFragment(filterUi)
                )
        }
        binding?.filter?.setOnClickListener {
            FilterDialog
                .Builder()
                .build()
                .setOnFilterListener { filter ->
                    filter?.let { it ->
                        filterUi = filter
                        collectLatestFlow(homeViewModel.propertiesCollectionPagedList(it.getQuery())) {
                            propertiesAdapter.submitData(it)
                        }
                    }
                }
                .show(
                    parentFragmentManager,
                    FilterDialog::class.java.name
                )
        }

        binding?.refreshProperty?.setOnRefreshListener {
            collectLatestFlow(homeViewModel.propertiesCollectionPagedList(filterUi.getQuery())) {
                propertiesAdapter.submitData(it)
            }
            binding?.refreshProperty?.isRefreshing = false
        }

        binding?.search?.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_GO) {
                activity?.hideSoftKeyBoard()
                collectLatestFlow(
                    homeViewModel.propertiesCollectionPagedList(
                        filterUi.getQuery(textView.text.toString())
                    )
                ) {
                    propertiesAdapter.submitData(it)
                }
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding?.search?.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                activity?.hideSoftKeyBoard()
                collectLatestFlow(
                    homeViewModel.propertiesCollectionPagedList(
                        filterUi.getQuery(binding?.search?.text.toString())
                    )
                ) {
                    propertiesAdapter.submitData(it)
                }
                return@setOnKeyListener true
            }
            return@setOnKeyListener false
        }

        binding?.searchInputLayout?.setEndIconOnClickListener {
            activity?.hideSoftKeyBoard()
            binding?.search?.setText("")
            binding?.search?.clearFocus()
            collectLatestFlow(homeViewModel.propertiesCollectionPagedList(filterUi.getQuery())) {
                propertiesAdapter.submitData(it)
            }
        }
        collectLatestFlow(homeViewModel.delete) { response ->
            when (response) {
                is State.Error -> {

                }
                is State.Loading -> {

                }
                is State.Success -> {
                    response.t?.let {
                        collectLatestFlow(homeViewModel.propertiesCollectionPagedList(filterUi.getQuery())) {
                            propertiesAdapter.submitData(it)
                        }
                    }
                }
            }
        }

        collectLatestFlow(homeViewModel.propertiesCollectionPagedList(filterUi.getQuery())) {
            propertiesAdapter.submitData(it)
        }

        collectLatestFlow(homeViewModel.user) {
            when (it) {
                is State.Error -> {}
                is State.Loading -> {}
                is State.Success -> {
                    userUi = it.t
                }
            }
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
                if (item.itemId == R.id.menu_profile) {
                    item.title =
                        if (userUi != null) "${userUi?.username}" else getString(R.string.app_name)
                }
                val iconMarginPx =
                    TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 4.toFloat(), resources.displayMetrics
                    )
                        .toInt()
                if (item.icon != null) {
                    item.icon = InsetDrawable(item.icon, iconMarginPx, 0, iconMarginPx, 0)
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
                    findNavController()
                        .navigate(
                            HomeFragmentDirections.actionHomeFragmentToProfileFragment(userUi)
                        )
                    true
                }
                R.id.menu_settings -> {
                    findNavController()
                        .navigate(
                            HomeFragmentDirections.actionHomeFragmentToSettingsFragment(userUi)
                        )
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