package al.viki.ui.details

import al.viki.model.PropertyUi
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PropertyDetailsFragmentArgs(
  public val `property`: PropertyUi
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(PropertyUi::class.java)) {
      result.putParcelable("property", this.property as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(PropertyUi::class.java)) {
      result.putSerializable("property", this.property as Serializable)
    } else {
      throw UnsupportedOperationException(PropertyUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(PropertyUi::class.java)) {
      result.set("property", this.property as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(PropertyUi::class.java)) {
      result.set("property", this.property as Serializable)
    } else {
      throw UnsupportedOperationException(PropertyUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): PropertyDetailsFragmentArgs {
      bundle.setClassLoader(PropertyDetailsFragmentArgs::class.java.classLoader)
      val __property : PropertyUi?
      if (bundle.containsKey("property")) {
        if (Parcelable::class.java.isAssignableFrom(PropertyUi::class.java) ||
            Serializable::class.java.isAssignableFrom(PropertyUi::class.java)) {
          __property = bundle.get("property") as PropertyUi?
        } else {
          throw UnsupportedOperationException(PropertyUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__property == null) {
          throw IllegalArgumentException("Argument \"property\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"property\" is missing and does not have an android:defaultValue")
      }
      return PropertyDetailsFragmentArgs(__property)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        PropertyDetailsFragmentArgs {
      val __property : PropertyUi?
      if (savedStateHandle.contains("property")) {
        if (Parcelable::class.java.isAssignableFrom(PropertyUi::class.java) ||
            Serializable::class.java.isAssignableFrom(PropertyUi::class.java)) {
          __property = savedStateHandle.get<PropertyUi?>("property")
        } else {
          throw UnsupportedOperationException(PropertyUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__property == null) {
          throw IllegalArgumentException("Argument \"property\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"property\" is missing and does not have an android:defaultValue")
      }
      return PropertyDetailsFragmentArgs(__property)
    }
  }
}
