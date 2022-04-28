package com.mrcprgt.valorantcompose.presentation.agentlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.mrcprgt.valorantcompose.presentation.AgentItem
import com.mrcprgt.valorantcompose.presentation.agentinfo.AgentInfoScreen
import com.mrcprgt.valorantcompose.presentation.destinations.AgentInfoScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun AgentListingScreen(
    navigator: DestinationsNavigator,
    viewModel: AgentViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )

    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(AgentListingEvent.Refresh)
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.agents.size) { i ->
                    val agent = state.agents[i]
                    AgentItem(
                        agent = agent,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                navigator.navigate(
                                    AgentInfoScreenDestination(uuid = agent.uuid)
                                )
                            }
                            .padding(16.dp)
                    )
                    if (i < state.agents.size) {
                        Divider(
                            modifier = Modifier.padding(
                                horizontal = 16.dp
                            )
                        )
                    }
                }
            }
        }
    }
}