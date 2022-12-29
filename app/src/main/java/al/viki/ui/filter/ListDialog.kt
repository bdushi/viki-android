package al.viki.ui.filter

import al.bruno.adapter.CustomListAdapter
import al.bruno.adapter.Selection
import al.viki.R
import al.viki.common.filterDiffUtil
import al.viki.databinding.DialogListBinding
import al.viki.databinding.DropDownItemBinding
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment

class ListDialog : DialogFragment(R.layout.dialog_list) {
    private var _binding: DialogListBinding? = null
    private val binding get() = _binding
    private val propertiesLoadStateAdapter =
        CustomListAdapter<Selection, DropDownItemBinding>(R.layout.drop_down_item, { t, vm ->
            vm.selection = t
    }, filterDiffUtil)

    class Builder {
        private var items: List<Selection> = emptyList()
        fun setTotalItem(items: List<Selection>): Builder {
            this.items = items
            return this
        }
        fun build(): ListDialog {
            return newInstance(items)
        }
    }

    companion object {
        private fun newInstance(items: List<Selection>): ListDialog {
            val args = Bundle()
            args.putParcelableArray(ITEMS, items.toTypedArray())
            val fragment = ListDialog()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.Theme_Viki_Dialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = DialogListBinding.bind(view)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            propertiesLoadStateAdapter.submitList(arguments?.getParcelableArrayList(ITEMS, Selection::class.java))
        } else {
            propertiesLoadStateAdapter.submitList(arguments?.getParcelableArrayList(ITEMS))
        }
        binding?.filterList?.adapter = propertiesLoadStateAdapter
        binding?.filterListCancel?.setOnClickListener {
            dismiss()
        }
        binding?.filterListOk?.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

const val ITEMS = "ITEMS"