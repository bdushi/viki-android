package al.viki.common

import al.bruno.adapter.Selection
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.core.model.User
import al.viki.model.GalleryUi
import al.viki.model.UserUi
import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.DiffUtil


val propertiesDiffUtil: DiffUtil.ItemCallback<PropertiesResponse> =
    object : DiffUtil.ItemCallback<PropertiesResponse>() {
        override fun areItemsTheSame(
            oldItem: PropertiesResponse,
            newItem: PropertiesResponse
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: PropertiesResponse,
            newItem: PropertiesResponse
        ): Boolean {
            return oldItem == newItem
        }
    }

val requestDiffUtil: DiffUtil.ItemCallback<RequestResponse> =
    object : DiffUtil.ItemCallback<RequestResponse>() {
        override fun areItemsTheSame(oldItem: RequestResponse, newItem: RequestResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RequestResponse,
            newItem: RequestResponse
        ): Boolean {
            return oldItem == newItem
        }
    }
val photoDiffUtil: DiffUtil.ItemCallback<GalleryUi> = object : DiffUtil.ItemCallback<GalleryUi>() {
    override fun areItemsTheSame(oldItem: GalleryUi, newItem: GalleryUi): Boolean {
        return oldItem.uri == newItem.uri
    }

    override fun areContentsTheSame(oldItem: GalleryUi, newItem: GalleryUi): Boolean {
        return oldItem == newItem
    }
}

val filterDiffUtil: DiffUtil.ItemCallback<Selection> = object : DiffUtil.ItemCallback<Selection>() {
    override fun areItemsTheSame(oldItem: Selection, newItem: Selection): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Selection, newItem: Selection): Boolean {
        TODO("Not yet implemented")
    }

}

//fun <T : Any> toMap(obj: T): Map<String, Any?> {
//    return (obj::class as KClass<T>).memberProperties.associate { prop ->
//        prop.name to prop.get(obj)?.let { value ->
//            if (value::class.isData) {
//                toMap(value)
//            } else {
//                value
//            }
//        }
//    }
//}


fun Activity.hideSoftKeyBoard() {
    val inputManager: InputMethodManager? =
        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputManager?.hideSoftInputFromWindow(
        this.currentFocus?.windowToken,
        InputMethodManager.HIDE_NOT_ALWAYS
    )
}

fun toUserUi(user: User?): UserUi? {
    return user?.let {
        UserUi(
            it.id,
            it.username,
            it.email,
            it.firstName,
            it.lastName,
            it.phone,
            it.address,
            it.authorities
        )
    }
}