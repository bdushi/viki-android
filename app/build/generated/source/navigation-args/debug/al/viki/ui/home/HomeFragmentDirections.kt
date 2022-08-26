package al.viki.ui.home

import al.viki.R
import al.viki.model.PropertyUi
import al.viki.model.RequestUi
import al.viki.model.UserUi
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeFragmentDirections private constructor() {
  private data class ActionHomeFragmentToPropertyDetailsFragment(
    public val `property`: PropertyUi
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_propertyDetailsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  private data class ActionHomeFragmentToProfileFragment(
    public val user: UserUi? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_profileFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(UserUi::class.java)) {
          result.putParcelable("user", this.user as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
          result.putSerializable("user", this.user as Serializable?)
        }
        return result
      }
  }

  private data class ActionHomeFragmentToRequestDetailsFragment(
    public val request: RequestUi
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_requestDetailsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
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
  }

  private data class ActionHomeFragmentToSettingsFragment(
    public val user: UserUi? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_homeFragment_to_settingsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(UserUi::class.java)) {
          result.putParcelable("user", this.user as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(UserUi::class.java)) {
          result.putSerializable("user", this.user as Serializable?)
        }
        return result
      }
  }

  public companion object {
    public fun actionHomeFragmentToNewPropertyFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_newPropertyFragment)

    public fun actionHomeFragmentToPropertyDetailsFragment(`property`: PropertyUi): NavDirections =
        ActionHomeFragmentToPropertyDetailsFragment(property)

    public fun actionHomeFragmentToProfileFragment(user: UserUi? = null): NavDirections =
        ActionHomeFragmentToProfileFragment(user)

    public fun actionHomeFragmentToNewRequestFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_newRequestFragment)

    public fun actionHomeFragmentToRequestDetailsFragment(request: RequestUi): NavDirections =
        ActionHomeFragmentToRequestDetailsFragment(request)

    public fun actionHomeFragmentToSettingsFragment(user: UserUi? = null): NavDirections =
        ActionHomeFragmentToSettingsFragment(user)
  }
}
