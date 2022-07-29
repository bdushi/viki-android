package al.viki.binding.util

import androidx.databinding.InverseMethod

object Converter {
    /*@InverseMethod("stringToDate")
    fun dateToString(view: EditText, oldValue: Long, value: Long): String {

    }

    fun stringToDate(view: EditText, oldValue: String, value: String): Long {
        // Converts String to long.
    }*/

    @InverseMethod("doubleToString")
    fun stringToDouble(quantity: Double): String {
        return ""
//        return format(quantity, 1)
    }

    fun doubleToString(quantity: String): Double {
        return try {
            java.lang.Double.parseDouble(quantity)
        } catch (ex: NumberFormatException) {
            0.0
        }
    }

    fun intToString(value: Int): String {
        return value.toString()
    }

    @InverseMethod("intToString")
    fun stringToInt(value: String): Int {
        return try {
            value.toInt()
        } catch (ex: NumberFormatException) {
            0
        }
    }
}