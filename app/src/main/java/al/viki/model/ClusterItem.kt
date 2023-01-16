package al.viki.model

import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

interface ClusterItem : ClusterItem, Parcelable {
    fun getId(): Long
    fun getLongitude(): Double
    fun getLatitude(): Double
    fun getDescription(): String
    override fun getPosition(): LatLng {
        return LatLng(getLatitude(), getLongitude())
    }

    override fun getSnippet(): String {
        return getDescription()
    }
}