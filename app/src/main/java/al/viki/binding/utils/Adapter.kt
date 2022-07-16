package al.viki.binding.utils

import al.bruno.adapter.DropDownAdapter
import al.bruno.adapter.DropDownArrayAdapter
import al.viki.R
import android.net.Uri
import android.util.Log
import android.widget.AdapterView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.squareup.picasso.Picasso
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
        Picasso.get().load(photoUrl).into(photoProfile)
    }

    @JvmStatic
    @BindingAdapter(value = ["bind:image"])
    fun imageView(imageView: AppCompatImageView, photoUrl: String) {
        Picasso.get()
            .load(File(photoUrl))
            .error(R.drawable.ic_outline_image_not_supported)
            .into(imageView)
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
