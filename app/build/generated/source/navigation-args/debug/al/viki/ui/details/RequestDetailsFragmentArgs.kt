package al.viki.ui.details

import al.viki.model.RequestUi
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class RequestDetailsFragmentArgs(
  public val request: RequestUi
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(RequestUi::class.java)) {
      result.putParcelable("request", this.request as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(RequestUi::class.java)) {
      result.putSerializable("request", this.request as Serializable)
    } else {
      throw UnsupportedOperationException(RequestUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(RequestUi::class.java)) {
      result.set("request", this.request as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(RequestUi::class.java)) {
      result.set("request", this.request as Serializable)
    } else {
      throw UnsupportedOperationException(RequestUi::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): RequestDetailsFragmentArgs {
      bundle.setClassLoader(RequestDetailsFragmentArgs::class.java.classLoader)
      val __request : RequestUi?
      if (bundle.containsKey("request")) {
        if (Parcelable::class.java.isAssignableFrom(RequestUi::class.java) ||
            Serializable::class.java.isAssignableFrom(RequestUi::class.java)) {
          __request = bundle.get("request") as RequestUi?
        } else {
          throw UnsupportedOperationException(RequestUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__request == null) {
          throw IllegalArgumentException("Argument \"request\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"request\" is missing and does not have an android:defaultValue")
      }
      return RequestDetailsFragmentArgs(__request)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        RequestDetailsFragmentArgs {
      val __request : RequestUi?
      if (savedStateHandle.contains("request")) {
        if (Parcelable::class.java.isAssignableFrom(RequestUi::class.java) ||
            Serializable::class.java.isAssignableFrom(RequestUi::class.java)) {
          __request = savedStateHandle.get<RequestUi?>("request")
        } else {
          throw UnsupportedOperationException(RequestUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__request == null) {
          throw IllegalArgumentException("Argument \"request\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"request\" is missing and does not have an android:defaultValue")
      }
      return RequestDetailsFragmentArgs(__request)
    }
  }
}
