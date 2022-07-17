package al.bruno.adapter

import android.view.View

interface OnClickListener<T> {
    fun onClick(view: View, t: T)
}