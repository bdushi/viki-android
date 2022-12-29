package al.viki.ui.filter

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.R
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentFilterBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.*
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterFragment : Fragment(R.layout.fragment_filter) {

    private val filterViewModel: FilterViewModel by viewModels()

    private var _binding: FragmentFilterBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    private val currencyAdapter =
        DropDownAdapter<CurrencyUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val unitAdapter =
        DropDownAdapter<UnitUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val cityAdapter =
        DropDownAdapter<CityUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val propertyTypeAdapter =
        DropDownAdapter<PropertyTypeUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    private val operationAdapter =
        DropDownAdapter<OperationUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFilterBinding.bind(view)
        binding?.filter = FilterUi()
        binding?.currencyAdapter = currencyAdapter
        binding?.unitAdapter = unitAdapter
        binding?.cityAdapter = cityAdapter
        binding?.operationAdapter = operationAdapter
        binding?.propertyTypeAdapter = propertyTypeAdapter
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.apply_filters -> {
                    findNavController().popBackStack()
                    true
                }
                else -> false
            }
        }

        collectLatestFlow(filterViewModel.propertyTypes) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { propertyType ->
                        val propertyList = propertyType.toMutableList()
                        propertyList.add(0, PropertyTypeUi(-1, "All", false))
                        propertyTypeAdapter.setItem(propertyList)
                    }
                }
                is State.Loading -> {}
            }
        }
        collectLatestFlow(filterViewModel.operations) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { operations ->
                        val operationList = operations.toMutableList()
                        operationList.add(0, OperationUi(-1, "All", false))
                        operationAdapter.setItem(operationList)
                    }
                }
                is State.Loading -> {}
            }
        }
        collectLatestFlow(filterViewModel.cities) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { cities ->
                        val cityList = cities.toMutableList()
                        cityList.add(0, CityUi(-1, "All", "-1", CountryUi(-1, "All", "-1"),false))
                        cityAdapter.setItem(cityList)
                    }
                }
                is State.Loading -> {}
            }
        }
        collectLatestFlow(filterViewModel.currencies) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { currencies ->
                        currencyAdapter.setItem(currencies)
                    }
                }
                is State.Loading -> {}
            }
        }
        collectLatestFlow(filterViewModel.units) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { units ->
                        unitAdapter.setItem(units)
                    }
                }
                is State.Loading -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}