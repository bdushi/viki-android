package al.bruno.core.data.source

import al.bruno.core.data.source.model.response.PropertyPageResponse
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response

interface PropertyDataSource {
    suspend fun properties(page: Int, size: Int) : Response<PropertyPageResponse>
    suspend fun properties(property: Property) : Response<ResponseBody>
}