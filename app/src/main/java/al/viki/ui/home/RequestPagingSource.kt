package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.data.source.PropertiesRepository
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertiesResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.common.NETWORK_PAGE_SIZE
import androidx.paging.PagingSource
import androidx.paging.PagingState

class RequestPagingSource  constructor(
    private val propertiesRepository: PropertiesRepository,
    private val query: Map<String, String>
) : PagingSource<Int, PropertiesResponse>() {
    override fun getRefreshKey(state: PagingState<Int, PropertiesResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PropertiesResponse> {
        val position = params.key ?: 0
        return when (val response = propertiesRepository.properties(
            page = position,
            size = params.loadSize,
            query = query
        )) {
            is Result.Error -> LoadResult.Error(Throwable(response.error))
            is Result.Success -> LoadResult.Page(
                data = response.data.pageResponse ?: arrayListOf(),
                prevKey = if (position == 0) null else position - 1,
                nextKey = if (response.data.empty) null else position + (params.loadSize / NETWORK_PAGE_SIZE)
            )
            else -> LoadResult.Error(Throwable())
        }
    }
    override val keyReuseSupported: Boolean
        get() = true
}