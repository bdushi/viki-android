package al.viki.ui.viki

import al.viki.foundation.nav.Actions
import al.viki.foundation.nav.Destinations
import al.viki.ui.home.Home
import al.viki.ui.home.VikiViewModel
import al.viki.ui.profile.Profile
import al.viki.ui.property.NewProperty
import al.viki.ui.property.PropertyViewModel
import al.viki.ui.theme.VikiTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Viki(
    vikiViewModel: VikiViewModel,
    propertyViewModel: PropertyViewModel,
    logOut: () -> Unit
) {
    val navController = rememberNavController()
    val actions = remember(navController) { Actions(navController) }
    VikiTheme {
        NavHost(navController = navController, startDestination = Destinations.Home) {
            composable(Destinations.Home) {
                Home(
                    vikiViewModel = vikiViewModel,
                    menuCallback = {
                        when (it) {
                            1 -> actions.newProperty()
                            6 -> logOut()
                        }
                    },
                    profile = actions.profile
                )
            }
            composable(Destinations.NewProperty) {
                NewProperty(
                    propertyViewModel = propertyViewModel,
                    navigateUp = actions.navigateUp,
                    success = actions.navigateUp
                )
            }
            composable(Destinations.Profile) {
                Profile()
            }
        }
    }
}