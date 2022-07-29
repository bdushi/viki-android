package al.viki.foundation.binding.util

import android.util.Patterns
import java.util.regex.Pattern

fun isValidEmail(mail: CharSequence?): Boolean? {
    return mail?.let { !Patterns.EMAIL_ADDRESS.matcher(it).matches() }
}

fun isValidPassword(password: CharSequence): Boolean {
    return !Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$")
        .matcher(password).matches()
}