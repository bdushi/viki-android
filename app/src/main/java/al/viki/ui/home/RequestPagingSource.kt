package al.viki.ui.home

import al.bruno.core.Result
import al.bruno.core.data.source.PropertyRepository
import al.bruno.core.data.source.model.response.PropertyResponse
import al.bruno.core.data.source.model.response.RequestResponse
import al.viki.common.NETWORK_PAGE_SIZE
import androidx.paging.PagingSource
import androidx.paging.PagingState

class RequestPagingSource  constructor(
    private val propertyRepository: PropertyRepository
) : PagingSource<Int, RequestResponse>() {
    override fun getRefreshKey(state: PagingState<Int, RequestResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, RequestResponse> {
        val position = params.key ?: 0
        return when (val response = propertyRepository.requests(
            page = position,
            size = params.loadSize
        )) {
            is Result.Error -> LoadResult.Error(Throwable(response.error))
            is Result.Success -> LoadResult.Page(
                data = response.data.pageResponse ?: arrayListOf(),
                prevKey = if (position == NETWORK_PAGE_SIZE) null else position - 1, //if (position == 1) null else position - 1,
                nextKey = if (response.data.empty) null else position + 1 //position + (params.loadSize / NETWORK_PAGE_SIZE)
            )
            else -> LoadResult.Error(Throwable())
        }
    }
    override val keyReuseSupported: Boolean
        get() = true
}