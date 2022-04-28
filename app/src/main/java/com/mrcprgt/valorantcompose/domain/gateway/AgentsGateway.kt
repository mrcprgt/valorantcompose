package com.mrcprgt.valorantcompose.domain.gateway

import com.mrcprgt.valorantcompose.domain.model.Agent
import com.mrcprgt.valorantcompose.util.Resource
import kotlinx.coroutines.flow.Flow

interface AgentsGateway {
    suspend fun fetchAgents(): Flow<Resource<List<Agent>>>
    suspend fun fetchAgent(uuid: String): Flow<Resource<Agent>>
}