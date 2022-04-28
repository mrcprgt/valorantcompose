package com.mrcprgt.valorantcompose.presentation.agentlist

sealed class AgentListingEvent {
    object Refresh : AgentListingEvent()
}