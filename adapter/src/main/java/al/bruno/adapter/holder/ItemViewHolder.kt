package al.bruno.adapter.holder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder<T, VM : ViewDataBinding>(
    private val vm: VM,
    private val bindingData: (t: T, vm: VM) -> Unit
) : RecyclerView.ViewHolder(vm.root) {
    fun bind(t: T) {
        bindingData.invoke(t, vm)
        vm.executePendingBindings()
    }
}