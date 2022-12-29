package al.bruno.adapter

import android.os.Parcelable

interface Selection : Parcelable{
    fun setSelected(selection: Boolean)
    fun isSelected() : Boolean
    fun searchCriteria() : String
    fun title() : String
}