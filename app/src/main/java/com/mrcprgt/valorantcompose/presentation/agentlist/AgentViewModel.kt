package com.mrcprgt.valorantcompose.presentation.agentlist

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrcprgt.valorantcompose.domain.gateway.AgentsGateway
import com.mrcprgt.valorantcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    private val repository: AgentsGateway
) : ViewModel() {

    var state by mutableStateOf(AgentListingState())

    init {
        fetchAgents()
    }

    fun onEvent(event: AgentListingEvent) {
        when (event) {
            is AgentListingEvent.Refresh -> {
                fetchAgents()
            }
            else -> {

            }
        }
    }

    fun fetchAgents() {
        viewModelScope.launch {
            Log.d("asd", "Asdad")
            repository.fetchAgents().collect { result ->
                when (result) {
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        result.data?.let { agents ->
                            state = state.copy(
                                agents = agents
                            )
                        }
                    }
                }

            }
        }
    }
}