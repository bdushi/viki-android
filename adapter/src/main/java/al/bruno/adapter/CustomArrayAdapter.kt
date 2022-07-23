package al.bruno.adapter

import al.bruno.adapter.holder.ItemViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class CustomArrayAdapter<T, VM : ViewDataBinding>(private var t: Array<T>, private val resources: Int, private val bindingData: (t: T, vm: VM) -> Unit) : RecyclerView.Adapter<ItemViewHolder<T, VM>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder<T, VM> {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(resources, parent, false), bindingData)
    }

    override fun onBindViewHolder(holder: ItemViewHolder<T, VM>, position: Int) {
        holder.bind(t[position])
    }

    override fun getItemCount(): Int {
        return t.size
    }

    fun setT(t: Array<T>) {
        this.t = t
        notifyDataSetChanged()
    }
}
