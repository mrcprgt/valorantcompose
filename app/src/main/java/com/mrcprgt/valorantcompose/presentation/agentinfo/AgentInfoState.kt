package com.mrcprgt.valorantcompose.presentation.agentinfo

import com.mrcprgt.valorantcompose.domain.model.Agent

data class AgentInfoState(
    val agent: Agent? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)