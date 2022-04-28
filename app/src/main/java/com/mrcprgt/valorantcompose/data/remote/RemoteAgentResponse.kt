package com.mrcprgt.valorantcompose.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteAgentResponse(
    @Json(name = "data")
    val agent: RemoteAgentsResponse.RemoteAgentData,
    @Json(name = "status")
    val status: Int
)
