package al.viki

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun decodeJwtPayload() {
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiYiIsIm5iZiI6MTY2MDIyNjkwOSwicm9sZXMiOlsiUk9MRV9BRE1JTiJdLCJpc3MiOiJ2aWtpIiwiZXhwIjoxNjYwMjMwNTA5LCJpYXQiOjE2NjAyMjY5MDl9.8ttGZNWl_nvYSwuYXoY1zp3LNLZijM5JZ2tU-KvNnv0"
        val chunks = token.split(".")
        val decoder: Base64.Decoder = Base64.getUrlDecoder()

        val payload = String(decoder.decode(chunks[1]))
        val header = String(decoder.decode(chunks[0]))
    }
}