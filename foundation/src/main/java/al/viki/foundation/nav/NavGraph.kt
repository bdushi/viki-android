package al.viki.foundation.nav

import al.viki.foundation.nav.Destinations.NewProperty
import al.viki.foundation.nav.Destinations.NewRequest
import al.viki.foundation.nav.Destinations.Profile
import al.viki.foundation.nav.Destinations.PropertyDetail
import androidx.navigation.NavHostController

object Destinations {
    const val Home = "home"
    const val NewRequest = "newRequest"
    const val NewProperty = "newProperty"
    const val PropertyDetail = "propertyDetail"
    const val Profile = "profile"

    object LeaveDetailArgs {
        const val LeaveId = "leaveId"
    }
}

class Actions(navController: NavHostController) {
    val openLeave: (Int) -> Unit = { taskId ->
        navController.navigate("$PropertyDetail/$taskId")
    }
    val newRequest: () -> Unit = {
        navController.navigate(NewRequest)
    }
    val newProperty: () -> Unit = {
        navController.navigate(NewProperty)
    }
    val profile: () -> Unit = {
        navController.navigate(Profile)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}