package al.bruno.core.data.source

import al.bruno.core.data.source.model.PropertyType
import retrofit2.Response

interface PropertyTypeDataSource {
    suspend fun propertyTypes() : Response<List<PropertyType>>
}