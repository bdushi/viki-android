package al.bruno.core.data.source

import al.bruno.core.data.source.remote.PropertyRemoteDataSource
import al.viki.domain.Property
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import javax.inject.Inject

class PropertyRepository @Inject constructor(
    private val propertyRemoteDataSource: PropertyRemoteDataSource) {
    suspend fun properties() : Response<List<Property>> {
        return propertyRemoteDataSource.properties()
    }

    suspend fun properties(@Body property: Property) : Response<ResponseBody> {
        return propertyRemoteDataSource.properties(property)
    }
}