package al.viki.model

import android.graphics.drawable.Drawable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import al.bruno.core.BuildConfig

data class ClusterItemUi(
    val id: Long,
    private val title: String,
    val description: String,
    val longitude: Double,
    val latitude: Double,
    val isRequest: Boolean,
    val url: String = "${BuildConfig.FILE_HOST_NAME}/resources/${id}/${id}_0",
    var drawable: Drawable? = null
) : ClusterItem {
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