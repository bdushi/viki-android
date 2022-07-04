package al.viki

import al.bruno.core.data.source.PropertyRepository
import al.viki.domain.Property
import androidx.paging.PagingSource
import androidx.paging.PagingState

class PropertiesPageSource constructor(
    private val leaveRepository: PropertyRepository
) : PagingSource<Int, Property>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Property> {
        return try {
            val position = params.key ?: 1
            val response = leaveRepository.properties() //leave(search = "", page = position, size = params.loadSize)
            val properties = response.body()
            if (response.isSuccessful && properties != null) {
                LoadResult.Page(
                    data = properties,
                    prevKey = if (position == 0) null else position - 1,
                    nextKey = if(properties.isEmpty()) 0 else 1 //if (leave.leave.isEmpty()) null else leave.number + 1
                )
            } else {
                /**
                 * LoadResult.Error(Exception("No Data"))
                 */
                LoadResult.Error(Exception(response.message()))
            }
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

    override fun getRefreshKey(state: PagingState<Int, Property>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}