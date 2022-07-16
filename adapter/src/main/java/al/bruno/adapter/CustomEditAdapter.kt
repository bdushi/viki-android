package al.bruno.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class CustomEditAdapter<T, VM: RecyclerView.ViewHolder, VH: RecyclerView.ViewHolder>(diffUtil: DiffUtil.ItemCallback<T>) : ListAdapter<T, RecyclerView.ViewHolder>(diffUtil) {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)) {
            ItemViewType.ITEM_VIEW_TYPE_HEADER.viewType -> onBindHeaderViewHolder(holder as VH)
            ItemViewType.ITEM_VIEW_TYPE_HEADER.viewType -> onBindItemViewHolder(holder as VM, getItem(position))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == ItemViewType.ITEM_VIEW_TYPE_HEADER.viewType) onHeaderViewHolder(parent, viewType) else onItemViewHolder(parent, viewType)
    }


    override fun getItemCount(): Int {
        return super.getItemCount() + 1
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            itemCount - 1 -> ItemViewType.ITEM_VIEW_TYPE_HEADER.viewType
            else -> ItemViewType.ITEM_VIEW_TYPE_ITEM.viewType
        }
    }

    abstract fun onItemViewHolder(itemViewGroup: ViewGroup, viewType: Int): VM
    abstract fun onHeaderViewHolder(editViewGroup: ViewGroup, viewType: Int): VH

    abstract fun onBindItemViewHolder(itemViewHolder: VM, t: T)
    abstract fun onBindHeaderViewHolder(headerViewHolder: VH)
}