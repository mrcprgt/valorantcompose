package com.mrcprgt.valorantcompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AgentsApi {

    @GET("agents")
    suspend fun getAgents(@Query("isPlayableCharacter") isPlayableCharacter: Boolean = true): RemoteAgentsResponse

    @GET("agents/{uuid}")
    suspend fun getAgentById(@Path("uuid") uuid: String): RemoteAgentResponse

    companion object {
        const val BASE_URL = "https://valorant-api.com/v1/"
    }
}