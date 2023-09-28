package al.bruno.common

import java.util.regex.Pattern

fun isValidEmail(mail: CharSequence?): Boolean? {
    return mail?.let { !Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$").matcher(it).matches() }
}

fun isValidPhone(phone: CharSequence?): Boolean? {
    return phone?.let { !Pattern.compile("^\\d{3}-\\d{3}-\\d{4}\$").matcher(it).matches() }
}

fun isValidPassword(password: CharSequence?): Boolean? {
    return password?.let { !Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$").matcher(it).matches() }
}