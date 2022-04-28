package com.mrcprgt.valorantcompose.presentation.agentinfo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrcprgt.valorantcompose.domain.gateway.AgentsGateway
import com.mrcprgt.valorantcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AgentInfoViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: AgentsGateway
) : ViewModel() {

    var state by mutableStateOf(AgentInfoState())

    init {
        viewModelScope.launch {
            val agentUuid = savedStateHandle.get<String>("uuid") ?: return@launch
            state = state.copy(isLoading = true)
            repository.fetchAgent(agentUuid).collect() { result ->
                when (result) {
                    is Resource.Error -> {

                    }
                    is Resource.Loading -> {

                    }
                    is Resource.Success -> {
                        result.data?.let {
                            state = state.copy(
                                agent = it,
                                isLoading = false
                            )
                        }

                    }
                }
            }
        }
    }
}