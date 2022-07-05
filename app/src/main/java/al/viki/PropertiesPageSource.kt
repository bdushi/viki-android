package al.viki

import al.bruno.core.Result
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.viki.domain.Property
import al.viki.ui.home.NETWORK_PAGE_SIZE
import androidx.paging.PagingSource
import androidx.paging.PagingState

class PropertiesPageSource constructor(
    private val leaveRepository: PropertyRepository
) : PagingSource<Int, PropertyResponse>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PropertyResponse> {
        val position = params.key ?: 0
        return when(val response = leaveRepository.properties(page = position, size = params.loadSize)) {
            is Result.Error -> {
                LoadResult.Error(Exception(response.error))
            }
            is Result.Loading -> {
                LoadResult.Error(Exception())
            }
            is Result.Success -> {
                LoadResult.Page(
                    data = response.data.pageResponse ?: arrayListOf(),
                    prevKey = if (position == 0) null else position - 1,
                    nextKey = if (response.data.empty) null else position + (params.loadSize / NETWORK_PAGE_SIZE) //response.data.pageNumber + 1
                )
            }
            is Result.Unauthorized -> {
                LoadResult.Error(Exception())
            }
        }
    }

    override val keyReuseSupported: Boolean
        get() = true

    override fun getRefreshKey(state: PagingState<Int, PropertyResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}