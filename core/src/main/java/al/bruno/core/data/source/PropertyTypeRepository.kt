package al.bruno.core.data.source

import al.bruno.core.Result
import al.bruno.core.data.source.model.PropertyType
import al.bruno.core.data.source.remote.PropertyTypeRemoteDataSource
import javax.inject.Inject

class PropertyTypeRepository @Inject constructor(private val propertyTypeDataSource: PropertyTypeRemoteDataSource) {
    suspend fun propertyTypes() : Result<List<PropertyType>> {
        return try {
            val response = propertyTypeDataSource.propertyTypes()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Result.Success(body)
            } else {
                Result.Error(response.message())
            }
        } catch (ex: Exception) {
            Result.Error(ex.message)
        }
    }
}