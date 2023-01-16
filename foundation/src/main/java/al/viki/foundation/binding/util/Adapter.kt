package al.viki.foundation.binding.util

import al.viki.foundation.R
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textfield.MaterialAutoCompleteTextView

object Adapter {
    @JvmStatic
    @BindingAdapter(value = ["bind:error"])
    fun error(imageView: AppCompatImageView, drawable: Drawable) {
        val finalHeight = (imageView.resources.displayMetrics.widthPixels * 2) / 1.75
        drawable.setTint(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
        imageView.minimumHeight = finalHeight.toInt()
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        imageView.setImageDrawable(drawable)
    }

    @JvmStatic
    @BindingAdapter("bind:profile")
    fun profile(photoProfile: ShapeableImageView, username: String?) {
        Glide
            .with(photoProfile.context)
            .load("https://firebasestorage.googleapis.com/v0/b/viki-135b4.appspot.com/o/photos%2F${username}%2F${username}?alt=media")
            .error(ContextCompat.getDrawable(photoProfile.context, R.drawable.ic_outline_person)?.also {
                it.setTint(ContextCompat.getColor(photoProfile.context, R.color.vikiColorBackground))
            })
            .into(photoProfile)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:uri"])
    fun bindUriImage(imageView: AppCompatImageView, photo: Uri?) {
        val finalHeight = (imageView.resources.displayMetrics.widthPixels * 1.5) / 1.75
        imageView.minimumHeight = finalHeight.toInt()
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        Glide
            .with(imageView.context)
            .load(photo)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_outline_image_not_supported)?.also {
                it.setTint(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
            })
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:image"])
    fun bindImage(imageView: AppCompatImageView, photo: Uri?) {
        val finalHeight = (imageView.resources.displayMetrics.widthPixels * 1.5) / 1.75
        imageView.minimumHeight = finalHeight.toInt()
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        Glide
            .with(imageView.context)
            .load(photo)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_outline_image_not_supported)?.also {
                it.setTint(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
            })
            .into(imageView)
    }

    /**
     * "https://firebasestorage.googleapis.com/v0/b/viki-135b4.appspot.com/o/photos%2F${id}%2F${id}_0?alt=media"
     */
    @JvmStatic
    @BindingAdapter(value = ["bind:cloud"])
    fun bindCloudImage(imageView: AppCompatImageView, url: String) {
        val finalHeight = (imageView.resources.displayMetrics.widthPixels * 1.5) / 1.75
        imageView.minimumHeight = finalHeight.toInt()
        imageView.adjustViewBounds = true
        imageView.scaleType = ImageView.ScaleType.FIT_CENTER
        Glide
            .with(imageView.context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .error(ContextCompat.getDrawable(imageView.context, R.drawable.ic_outline_image_not_supported)?.also {
                it.setTint(ContextCompat.getColor(imageView.context, R.color.vikiColorBackground))
            })
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:onItemClick"], requireAll = true)
    fun adapter(
        materialAutoCompleteTextView: MaterialAutoCompleteTextView,
        onItemClickListener: AdapterView.OnItemClickListener
    ) {
        materialAutoCompleteTextView.onItemClickListener = onItemClickListener
    }

    @JvmStatic
    @BindingAdapter("bind:onEditorEnterAction")
    fun onEditorEnterAction(editText: EditText, onClick : View.OnClickListener) {
        editText.setOnEditorActionListener { textView, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                onClick.onClick(textView)
            }
            false
        }
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:tint"], requireAll = true)
    fun tint(
        imageView: AppCompatImageView,
        tintColor: ColorStateList
    ) {
        imageView.imageTintList = tintColor
    }

}
