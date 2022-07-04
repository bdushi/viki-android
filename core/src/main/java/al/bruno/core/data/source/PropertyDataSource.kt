package al.bruno.core.data.source

import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body

interface PropertyDataSource {
    suspend fun properties() : Response<List<Property>>
    suspend fun properties(@Body property: Property) : Response<ResponseBody>
}