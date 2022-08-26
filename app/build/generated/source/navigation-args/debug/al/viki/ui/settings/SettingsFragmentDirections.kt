package al.viki.ui.settings

import al.viki.R
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class SettingsFragmentDirections private constructor() {
  public companion object {
    public fun actionSettingsFragmentToRequestNewAccountFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_settingsFragment_to_requestNewAccountFragment)
  }
}
