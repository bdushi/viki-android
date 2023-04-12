package al.bruno.analytics

import android.os.Bundle

//fun toBundle(vararg params: Pair<String, Any?>): Bundle {
//    val bundle = Bundle()
//    params.forEach {
//        bundle.putString(it.first, it.second.toString())
//    }
//    return bundle
//}

fun Array<out Pair<String, Any?>>.toBundle(): Bundle {
    val bundle = Bundle()
    for ((key, value) in this) {
        bundle.putString(key, value.toString())
    }
    return bundle
}