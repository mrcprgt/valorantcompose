package com.mrcprgt.valorantcompose.presentation.agentlist

import com.mrcprgt.valorantcompose.domain.model.Agent

data class AgentListingState(
    val agents: List<Agent>  = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,

)