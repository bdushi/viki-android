package al.viki.binding.utils

import al.bruno.adapter.DropDownAdapter
import al.bruno.adapter.DropDownArrayAdapter
import al.viki.R
import al.viki.common.ONE_MEGABYTE
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.AdapterView
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.EncodeStrategy
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.File

object Adapter {
    @JvmStatic
    @BindingAdapter("bind:cover")
    fun coverProvider(photoProfile: ShapeableImageView, photoUrl: Uri) {
        photoProfile.shapeAppearanceModel =
            ShapeAppearanceModel
                .builder()
                .setAllCornerSizes(ShapeAppearanceModel.PILL)
                .build()
        Glide.with(photoProfile.context).load(photoUrl).into(photoProfile)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:image"])
    fun imageView(imageView: AppCompatImageView, photo: String) {
        Glide
            .with(imageView.context)
            .load(photo)
            .error(R.drawable.ic_outline_image_not_supported)
            .into(imageView)
    }
    @JvmStatic
    @BindingAdapter(value = ["bind:cloud"])
    fun download(imageView: AppCompatImageView, id: Long) {
//        val finalHeight =
//            (imageView.resources.displayMetrics.widthPixels * 2) / (photo.width.toFloat() / photo.height.toFloat())
//        imageView.minimumHeight = finalHeight.toInt()
        imageView.minimumHeight = imageView.resources.displayMetrics.widthPixels
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        Glide
            .with(imageView.context)
            .load("https://firebasestorage.googleapis.com/v0/b/viki-135b4.appspot.com/o/photos%2F${id}%2F${id}_0?alt=media")
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_outline_image_not_supported)?.also {
                it.setTint(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
            })
            .into(imageView)
//        Firebase.storage.reference.child(path)
//            .getBytes(ONE_MEGABYTE)
//            .addOnSuccessListener {
//                Glide
//                    .with(imageView.context)
//                    .load(it)
//                    .diskCacheStrategy(DiskCacheStrategy.DATA)
//                    .onlyRetrieveFromCache(true)
//                    .error(R.drawable.ic_outline_image_not_supported)
//                    .into(imageView)
//            }.addOnFailureListener {
//                imageView.minimumHeight = imageView.resources.displayMetrics.widthPixels
//                imageView.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
//                imageView.setImageResource(R.drawable.ic_outline_image_not_supported)
//            }
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:adapter", "bind:onItemClick"], requireAll = true)
    fun adapter(
        materialAutoCompleteTextView: MaterialAutoCompleteTextView,
        dropDownAdapter: DropDownAdapter<*, *>,
        onItemClickListener: AdapterView.OnItemClickListener
    ) {
        materialAutoCompleteTextView.setAdapter(dropDownAdapter)
        materialAutoCompleteTextView.onItemClickListener = onItemClickListener
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:adapter"], requireAll = true)
    fun adapter(
        materialAutoCompleteTextView: MaterialAutoCompleteTextView,
        dropDownAdapter: DropDownArrayAdapter<*, *, *>
    ) {
        materialAutoCompleteTextView.setAdapter(dropDownAdapter)
    }
}
