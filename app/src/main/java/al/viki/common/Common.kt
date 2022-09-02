package al.viki.common

import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.model.PhotoUi
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.recyclerview.widget.DiffUtil


val propertiesDiffUtil: DiffUtil.ItemCallback<PropertyResponse> =
    object : DiffUtil.ItemCallback<PropertyResponse>() {
        override fun areItemsTheSame(oldItem: PropertyResponse, newItem: PropertyResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PropertyResponse, newItem: PropertyResponse): Boolean {
            return oldItem == newItem
        }
    }

val requestDiffUtil: DiffUtil.ItemCallback<RequestResponse> =
    object : DiffUtil.ItemCallback<RequestResponse>() {
        override fun areItemsTheSame(oldItem: RequestResponse, newItem: RequestResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RequestResponse, newItem: RequestResponse): Boolean {
            return oldItem == newItem
        }
    }
val photoDiffUtil: DiffUtil.ItemCallback<PhotoUi> = object : DiffUtil.ItemCallback<PhotoUi>() {
    override fun areItemsTheSame(oldItem: PhotoUi, newItem: PhotoUi): Boolean {
        return oldItem.photo == newItem.photo
    }

    override fun areContentsTheSame(oldItem: PhotoUi, newItem: PhotoUi): Boolean {
        return oldItem == newItem
    }
}



fun Activity.hideSoftKeyBoard() {
    val inputManager: InputMethodManager? =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputManager?.hideSoftInputFromWindow(this.currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}