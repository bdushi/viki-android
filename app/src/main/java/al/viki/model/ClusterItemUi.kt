package al.viki.model

import al.viki.BuildConfig
import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

data class ClusterItemUi(
    val id: Long,
    private val title: String,
    val description: String,
    val longitude: Double,
    val latitude: Double,
    val isRequest: Boolean,
    var drawable: Drawable? = null
) : ClusterItem {
    fun drawable(requestManager: RequestManager) {
        requestManager
            .load("${BuildConfig.FILE_HOST_NAME}/resources/${id}/${id}_0")
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    drawable = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    drawable = placeholder
                }
            })
    }

    override fun getTitle(): String {
        return title
    }

    override fun getPosition(): LatLng {
        return LatLng(latitude, longitude)
    }

    override fun getSnippet(): String {
        return description
    }

    override fun getZIndex(): Float {
        return 0.0f
    }
}