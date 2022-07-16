package al.bruno.adapter.holder

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder<VM : ViewDataBinding>( itemView: View, private val bindingData: (vm: VM) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val binding: VM? = DataBindingUtil.bind(itemView)
    fun bind() {
        binding?.let {
            bindingData.invoke(it)
            it.executePendingBindings()
        }
    }
}