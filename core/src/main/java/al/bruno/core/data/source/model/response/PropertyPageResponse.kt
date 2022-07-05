package al.bruno.core.data.source.model.response

import com.google.gson.annotations.SerializedName

data class PropertyPageResponse(
    @SerializedName("content")
    val pageResponse: List<PropertyResponse>?,
    val totalSize: Int,
    val totalPages: Int,
    val empty: Boolean,
    val size: Int,
    val offset: Int,
    val pageNumber: Int,
    val numberOfElements: Int)