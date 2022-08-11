package al.viki.foundation.ui.utils

import android.util.Patterns
import java.util.regex.Pattern

fun isValidEmail(mail: CharSequence?): Boolean? {
    return mail?.let { !Patterns.EMAIL_ADDRESS.matcher(it).matches() }
}

fun isValidPhone(mail: CharSequence?): Boolean? {
    return mail?.let { !Patterns.PHONE.matcher(it).matches() }
}

fun isValidPassword(password: CharSequence?): Boolean? {
    return password?.let { !Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$").matcher(it).matches() }
}