package al.bruno.core.data.source.model.request

import al.bruno.core.data.source.model.Authority

data class RequestAccount(
    val email: String,
    val authority: Authority
)
