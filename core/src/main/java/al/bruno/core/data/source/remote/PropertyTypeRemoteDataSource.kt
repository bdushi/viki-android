package al.bruno.core.data.source.remote

import al.bruno.core.data.source.PropertyTypeDataSource
import al.bruno.core.data.source.model.PropertyType
import al.bruno.core.data.source.remote.service.PropertyTypeService
import retrofit2.Response
import javax.inject.Inject

class PropertyTypeRemoteDataSource @Inject constructor(private val propertyTypeService: PropertyTypeService): PropertyTypeDataSource{
    override suspend fun propertyTypes(): Response<List<PropertyType>> {
        return propertyTypeService.propertyTypes()
    }
}