package al.viki.ui.map

import al.bruno.core.BuildConfig
import al.viki.foundation.R
import al.viki.model.ClusterItem
import android.content.Context
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
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
    private val context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<ClusterItem>
) : DefaultClusterRenderer<ClusterItem>(context, map, clusterManager) {
    private val mIconGenerator: IconGenerator = IconGenerator(context)
    private val mImageView: ImageView = ImageView(context)
    private val mDimension = context.resources.getDimension(R.dimen.custom_profile_image).toInt()
    init {
        val padding = context.resources.getDimension(R.dimen.custom_profile_padding).toInt()
        mImageView.layoutParams = ViewGroup.LayoutParams(mDimension, mDimension)
        mImageView.setPadding(padding, padding, padding, padding)
        mImageView.adjustViewBounds = true
        mImageView.scaleType = ImageView.ScaleType.FIT_CENTER
        mIconGenerator.setContentView(mImageView)
    }

    /**
     * Draw a single person - show their profile photo and set the info window to show their name
     */
    override fun onBeforeClusterItemRendered(item: ClusterItem, markerOptions: MarkerOptions) {
        markerOptions
            .icon(getItemIcon(context, item))
            .title(item.title)
    }

    /**
     * Same implementation as onBeforeClusterItemRendered() (to update cached markers)
     */
    override fun onClusterItemUpdated(item: ClusterItem, marker: Marker) {
        marker.setIcon(getItemIcon(context, item))
        marker.title = item.title
    }

    /**
     * Get a descriptor for a single person (i.e., a marker outside a cluster) from their
     * profile photo to be used for a marker icon
     *
     * @param person person to return an BitmapDescriptor for
     * @return the person's profile photo as a BitmapDescriptor
     */
    private fun getItemIcon(context: Context, item: ClusterItem): BitmapDescriptor {
        Glide
            .with(context)
            .load("${BuildConfig.FILE_HOST_NAME}/resources/${item.getId()}/${item.getId()}_0")
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .error(ContextCompat.getDrawable(context, R.drawable.ic_outline_image_not_supported)?.also { drawable ->
                drawable.setTint(ContextCompat.getColor(context, R.color.vikiColorBackground))
            })
            .into(mImageView)
        return BitmapDescriptorFactory.fromBitmap(mIconGenerator.makeIcon())
    }

    override fun shouldRenderAsCluster(cluster: Cluster<ClusterItem>): Boolean {
        return cluster.size > 1
    }
}