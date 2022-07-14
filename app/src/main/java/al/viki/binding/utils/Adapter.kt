package al.viki.binding.utils

import al.bruno.adapter.DropDownAdapter
import al.bruno.adapter.DropDownArrayAdapter
import al.bruno.adapter.OnItemClickListener
import android.net.Uri
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.squareup.picasso.Picasso

object Adapter {
    @JvmStatic
    @BindingAdapter("bind:image")
    fun imageProvider(photoProfile: ShapeableImageView, photoUrl: Uri) {
        photoProfile.shapeAppearanceModel =
                ShapeAppearanceModel
                        .builder()
                        .setAllCornerSizes(ShapeAppearanceModel.PILL)
                        .build()
        Picasso.get().load(photoUrl).into(photoProfile)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:cover"], requireAll = false)
    fun coverProvider(imageView: ImageView, url: String?) {
        Picasso.get()
                .load(url)
//                .error(R.drawable.ic_image_not_supported_24px)
                .into(imageView)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:adapter", "bind:onItemClick"], requireAll = true)
    fun adapter(materialAutoCompleteTextView: MaterialAutoCompleteTextView, dropDownAdapter: DropDownAdapter<*, *>, onItemClickListener: AdapterView.OnItemClickListener) {
        materialAutoCompleteTextView.setAdapter(dropDownAdapter)
        materialAutoCompleteTextView.onItemClickListener = onItemClickListener
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:adapter"], requireAll = true)
    fun adapter(materialAutoCompleteTextView: MaterialAutoCompleteTextView, dropDownAdapter: DropDownArrayAdapter<*, *, *>) {
        materialAutoCompleteTextView.setAdapter(dropDownAdapter)
    }
}
