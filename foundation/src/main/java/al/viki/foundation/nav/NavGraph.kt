package al.viki.foundation.nav

import al.viki.foundation.nav.Destinations.AddLeave
import al.viki.foundation.nav.Destinations.LeaveDetail
import androidx.navigation.NavHostController

object Destinations {
    const val Home = "home"
    const val AddLeave = "addLeave"
    const val SignIn = "signIn"
    const val SignUp = "signUp"
    const val LeaveDetail = "leaveDetail"

    object LeaveDetailArgs {
        const val LeaveId = "leaveId"
    }
}

class Actions(navController: NavHostController) {
    val openLeave: (Int) -> Unit = { taskId ->
        navController.navigate("$LeaveDetail/$taskId")
    }
    val addLeave: () -> Unit = {
        navController.navigate(AddLeave)
    }
    val navigateUp: () -> Unit = {
        navController.popBackStack()
    }
}