package al.bruno.adapter

/**
 * https://developer.android.com/guide/topics/graphics/drawable-animation
 */

import al.bruno.adapter.holder.ViewHolderAdapter
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.ViewDataBinding
import java.util.*


class DropDownAdapter<T : Selection, VM : ViewDataBinding>(
    private val resource: Int,
    private val bindingData: (t: T, vm: VM) -> Unit
) : BaseAdapter(), Filterable {
    private var selection = -1
    private var t: List<T> = listOf()
    private var o: List<T> = listOf()
    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var contentView = view
        if (contentView == null) {
            contentView = LayoutInflater.from(parent.context).inflate(resource, parent, false)
            val spinnerViewHolder = ViewHolderAdapter(contentView, bindingData)
            spinnerViewHolder.bind(t[position])
            contentView.tag = spinnerViewHolder
        } else {
            val spinnerViewHolder = contentView.tag as ViewHolderAdapter<T, VM>
            spinnerViewHolder.bind(t[position])
        }
        /*val tt: T = t[position]
        if (position == selection) {
            tt.selection(true)
        } else {
            tt.selection(false)
        }*/
        return contentView
    }

    override fun getCount(): Int {
        return t.size
    }

    override fun getItem(i: Int): T {
        return t[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    fun setItem(t: List<T>) {
        this.t = t
        this.o = t
        notifyDataSetChanged()
    }

    fun setSelection(position: Int) {
        this.selection = position
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                val prefix = charSequence.toString().lowercase(Locale.getDefault())
                if (prefix.isEmpty()) {
                    filterResults.values = o
                    filterResults.count = o.size
                } else {
                    val searchResult: MutableList<Selection> = mutableListOf()
                    for (oo in o) {
                        if (oo.searchCriteria().lowercase(Locale.getDefault()).contains(prefix)) {
                            searchResult.add(oo)
                        }
                        filterResults.values = searchResult
                        filterResults.count = searchResult.size
                    }
                }
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
                filterResults?.let {
                    t = filterResults.values as List<T>
                } ?: run {
                    arrayListOf<Selection>()
                    notifyDataSetChanged()
                }
                notifyDataSetInvalidated()
            }
        }
    }
}