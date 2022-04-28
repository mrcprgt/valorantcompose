package com.mrcprgt.valorantcompose.data.repository

import com.mrcprgt.valorantcompose.data.mappers.toDomain
import com.mrcprgt.valorantcompose.data.remote.AgentsApi
import com.mrcprgt.valorantcompose.domain.gateway.AgentsGateway
import com.mrcprgt.valorantcompose.domain.model.Agent
import com.mrcprgt.valorantcompose.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AgentsRepository @Inject constructor(
    private val api: AgentsApi
) : AgentsGateway {

    override suspend fun fetchAgents(): Flow<Resource<List<Agent>>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = api.getAgents(isPlayableCharacter = true).data
                emit(Resource.Success(
                    data = response.map {
                        it.toDomain()
                    }.sortedBy {
                        it.displayName
                    }
                ))
                emit(Resource.Loading(false))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data."))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load data."))
            }
        }
    }

    override suspend fun fetchAgent(uuid: String): Flow<Resource<Agent>> {
        return flow {
            emit(Resource.Loading(true))
            try {
                val response = api.getAgentById(uuid).agent
                emit(
                    Resource.Success(
                        data = response.toDomain()
                    )
                )
                emit(Resource.Loading(false))
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load agent."))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Couldn't load agent."))
            }
        }
    }
}