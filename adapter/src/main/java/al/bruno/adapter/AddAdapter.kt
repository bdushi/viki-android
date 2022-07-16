package al.bruno.adapter

import al.bruno.adapter.holder.CustomViewHolder
import al.bruno.adapter.holder.HeaderViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil

class AddAdapter<T, VM: ViewDataBinding, VH: ViewDataBinding>(
    private val item: Int,
    private val header: Int,
    private val bindingItem: (t: T, vm: VM) -> Unit,
    private val bindingHeader: (vm: VH) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T>
) : CustomEditAdapter<T, CustomViewHolder<T, VM>, HeaderViewHolder<VH>>(diffUtil) {
    override fun onItemViewHolder(itemViewGroup: ViewGroup, viewType: Int): CustomViewHolder<T, VM> {
        return CustomViewHolder(
            LayoutInflater.from(itemViewGroup.context).inflate(item, itemViewGroup, false), bindingItem)
    }

    override fun onBindItemViewHolder(itemViewHolder: CustomViewHolder<T, VM>, t: T) {
        itemViewHolder.bind(t)
        Log.d("TAG__", t.toString())
    }

    override fun onHeaderViewHolder(
        editViewGroup: ViewGroup,
        viewType: Int
    ): HeaderViewHolder<VH> {
        return HeaderViewHolder(
            LayoutInflater.from(editViewGroup.context).inflate(header, editViewGroup, false), bindingHeader)
    }

    override fun onBindHeaderViewHolder(headerViewHolder: HeaderViewHolder<VH>) {
        headerViewHolder.bind()
    }
}