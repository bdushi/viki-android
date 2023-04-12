package al.viki.ui.map

import al.viki.foundation.R
import al.viki.model.ClusterItemUi
import android.content.Context
import android.graphics.BitmapFactory
import android.view.ViewGroup
import android.widget.ImageView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.google.maps.android.ui.IconGenerator

class ItemRenderer(
    context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<ClusterItemUi>
) : DefaultClusterRenderer<ClusterItemUi>(context, map, clusterManager) {
    private val mIconGenerator: IconGenerator = IconGenerator(context)
    private val mImageView: ImageView = ImageView(context)

    init {
        val dimension = context.resources.getDimension(R.dimen.custom_profile_image).toInt()
        val padding = context.resources.getDimension(R.dimen.custom_profile_padding).toInt()
        mImageView.layoutParams = ViewGroup.LayoutParams(dimension, dimension)
        mImageView.setPadding(padding, padding, padding, padding)
        mImageView.adjustViewBounds = true
        mImageView.scaleType = ImageView.ScaleType.FIT_XY
        mIconGenerator.setContentView(mImageView)
    }

    /**
     * Draw a single person - show their profile photo and set the info window to show their name
     */
    override fun onBeforeClusterItemRendered(item: ClusterItemUi, markerOptions: MarkerOptions) {
        markerOptions
            .icon(getItemIcon(item))
            .title(item.title)
    }

    /**
     * Same implementation as onBeforeClusterItemRendered() (to update cached markers)
     */
    override fun onClusterItemUpdated(item: ClusterItemUi, marker: Marker) {
        marker.setIcon(getItemIcon(item))
        marker.title = item.title
        marker.tag = item
    }

    override fun shouldRenderAsCluster(cluster: Cluster<ClusterItemUi>): Boolean {
        return cluster.size > 1
    }

    /**
     * Get a descriptor for a single person (i.e., a marker outside a cluster) from their
     * profile photo to be used for a marker icon
     *
     * @param person person to return an BitmapDescriptor for
     * @return the person's profile photo as a BitmapDescriptor
     */
    private fun getItemIcon(item: ClusterItemUi): BitmapDescriptor  {
        mImageView.setImageDrawable(item.drawable)
        return BitmapDescriptorFactory.fromBitmap(mIconGenerator.makeIcon())
    }
}