package al.viki.foundation.common

import android.content.Context
import android.view.View
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStream

inline fun <T> LifecycleOwner.collectFlow(
    flow: Flow<T>,
    crossinline collector: suspend (T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow
                .catch { e -> e.printStackTrace() }
                .collect { collector(it) }
        }
    }
}

inline fun <T> LifecycleOwner.collectLatestFlow(
    flow: Flow<T>,
    crossinline collector: suspend (T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow
                .catch { e -> e.printStackTrace() }
                .collectLatest { collector(it) }
        }
    }
}

inline fun <T> LifecycleOwner.collectLatestFlowIO(
    flow: Flow<T>,
    crossinline collector: suspend (T) -> Unit
) {
    lifecycleScope.launch(Dispatchers.Default) {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow
                .catch { e -> e.printStackTrace() }
                .collectLatest { collector(it) }
        }
    }
}

fun InputStream.toFile(context: Context): File {
    val outputFile = File.createTempFile("viki", ".extension",  context.cacheDir)
    this.use { input ->
        outputFile.outputStream().use { output ->
            input.copyTo(output)
        }
    }
    return outputFile
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun EditText.isNotEmpty() : Boolean {
    return this.text.isNotEmpty()
}

fun EditText.isEmpty() : Boolean {
    return this.text.isEmpty()
}