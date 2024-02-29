package al.bruno.adapter

import al.bruno.adapter.holder.ItemViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

class PagedListAdapter<T : Any, VM: ViewDataBinding>(
    private val r: Int,
    private val bindingData: (t: T, vm: VM) -> Unit,
    diffUtil: DiffUtil.ItemCallback<T>
) : PagingDataAdapter<T, ItemViewHolder<T, VM>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<T, VM> {
        return ItemViewHolder(DataBindingUtil.bind(LayoutInflater.from(parent.context).inflate(r, parent, false))!!, bindingData)
    }

    override fun onBindViewHolder(holder: ItemViewHolder<T, VM>, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
}