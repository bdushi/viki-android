package al.bruno.adapter

import al.bruno.adapter.holder.ItemViewHolder
import al.bruno.adapter.holder.HeaderViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil

class AddAdapter<T, VM: ViewDataBinding, VH: ViewDataBinding>(
    private val item: Int,
    private val header: Int,
    private val bindingItem: (t: T, vm: VM) -> Unit,
    private val bindingHeader: (vm: VH) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T>
) : CustomEditAdapter<T, ItemViewHolder<T, VM>, HeaderViewHolder<VH>>(diffUtil) {
    override fun onItemViewHolder(itemViewGroup: ViewGroup, viewType: Int): ItemViewHolder<T, VM> {
        return ItemViewHolder(DataBindingUtil.bind(LayoutInflater.from(itemViewGroup.context).inflate(item, itemViewGroup, false))!!, bindingItem)
    }

    override fun onBindItemViewHolder(itemViewHolder: ItemViewHolder<T, VM>, t: T) {
        itemViewHolder.bind(t)
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