package al.viki.ui.filter

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.R
import al.viki.databinding.DialogFilterBinding
import al.viki.databinding.DropDownItemBinding
import al.viki.foundation.common.collectLatestFlow
import al.viki.model.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilterDialog : DialogFragment() {

    private val filterViewModel: FilterViewModel by viewModels()

    private var onFilterListener: ((FilterUi?) -> Unit)? = null

    private var _binding: DialogFilterBinding? = null
    private var filterUi = FilterUi()
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

    class Builder {
        fun build(): FilterDialog {
            return newInstance()
        }
    }

    companion object {
        private fun newInstance(): FilterDialog {
            return FilterDialog()
        }
    }

    fun setOnFilterListener(onFilterListener: ((FilterUi?) -> Unit)): FilterDialog {
        this.onFilterListener = onFilterListener
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_Viki_Dialog)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = DialogFilterBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.filter = filterUi
        binding?.currencyAdapter = currencyAdapter
        binding?.unitAdapter = unitAdapter
        binding?.cityAdapter = cityAdapter
        binding?.operationAdapter = operationAdapter
        binding?.propertyTypeAdapter = propertyTypeAdapter
        binding?.topAppBar?.setNavigationOnClickListener {
            dismiss()
        }

        binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.apply -> {
                    val f = binding?.filter
                    val ff = filterUi
                    onFilterListener?.invoke(f)
                    dismiss()
                    true
                }
                else -> false
            }
        }
        binding?.lifecycleOwner = this
        collectLatestFlow(filterViewModel.propertyTypes) {
            when (it) {
                is State.Error -> {}
                is State.Success -> {
                    it.t?.let { propertyType ->
                        val propertyList = propertyType.toMutableList()
                        propertyList.add(0, PropertyTypeUi(-1, "ALL", false))
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
                        operationList.add(0, OperationUi(-1, "ALL", false))
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
                        cityList.add(0, CityUi(-1, "ALL", "-1", CountryUi(-1, "ALL", "-1"),false))
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
                        val currencyList  = currencies.toMutableList()
                        currencyList.add(0, CurrencyUi(-1, "ALL", "all", "all", ".", false))
                        currencyAdapter.setItem(currencyList)
                    }
                }
                is State.Loading -> {}
            }
        }
        collectLatestFlow(filterViewModel.units) {
            when (it) {
                is State.Error -> {

                }
                is State.Success -> {
                    it.t?.let { units ->
                        val unitList = units.toMutableList()
                        unitList.add(0, UnitUi(-1, "ALL", false))
                        unitAdapter.setItem(unitList)
                    }
                }
                is State.Loading -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}