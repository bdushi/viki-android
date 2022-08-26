package al.viki.ui.settings

import al.viki.model.UserUi
import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class SettingsFragmentArgs(
  public val user: UserUi? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(UserUi::class.java)) {
      result.putParcelable("user", this.user as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
      result.putSerializable("user", this.user as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(UserUi::class.java)) {
      result.set("user", this.user as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
      result.set("user", this.user as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SettingsFragmentArgs {
      bundle.setClassLoader(SettingsFragmentArgs::class.java.classLoader)
      val __user : UserUi?
      if (bundle.containsKey("user")) {
        if (Parcelable::class.java.isAssignableFrom(UserUi::class.java) ||
            Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
          __user = bundle.get("user") as UserUi?
        } else {
          throw UnsupportedOperationException(UserUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __user = null
      }
      return SettingsFragmentArgs(__user)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SettingsFragmentArgs {
      val __user : UserUi?
      if (savedStateHandle.contains("user")) {
        if (Parcelable::class.java.isAssignableFrom(UserUi::class.java) ||
            Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
          __user = savedStateHandle.get<UserUi?>("user")
        } else {
          throw UnsupportedOperationException(UserUi::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __user = null
      }
      return SettingsFragmentArgs(__user)
    }
  }
}
