package al.bruno.core.data.source.remote.service

import al.bruno.core.data.source.model.PropertyType
import retrofit2.Response
import retrofit2.http.GET

interface PropertyTypeService {
    @GET("api/propertyTypes")
    suspend fun propertyTypes() : Response<List<PropertyType>>
}