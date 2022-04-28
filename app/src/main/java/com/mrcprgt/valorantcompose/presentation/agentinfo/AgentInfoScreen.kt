package com.mrcprgt.valorantcompose.presentation.agentinfo

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ramcosta.composedestinations.annotation.Destination

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Destination
fun AgentInfoScreen(
    uuid: String,
    viewModel: AgentInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.error == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            state.agent?.let { agent ->
                Column(
                ) {
                    Text(
                        text = agent.displayName,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.onBackground,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        item {
                            val lazyListState = rememberLazyListState()
                            var scrolledY = 0f
                            var previousOffset = 0
                            AsyncImage(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(agent.fullPortraitV2)
                                    .crossfade(true)
                                    .build(),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .align(Alignment.CenterHorizontally)
                                    .fillMaxWidth(1f)
                                    .height(360.dp)
                                    .graphicsLayer {
                                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                        translationY = scrolledY * 0.5f
                                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                                    }
                            )
                        }
                        item {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Abilities",
                                fontSize = 12.sp,
                                fontStyle = FontStyle.Normal,
                                fontWeight = FontWeight.Light,
                                color = MaterialTheme.colors.onBackground,
                                modifier = Modifier
                                    .padding(start = 8.dp)
                            )
                        }
                        items(state.agent.abilities.size) { i ->
                            val ability = state.agent.abilities[i]
                            AbilityItem(
                                ability = ability,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            if (i < state.agent.abilities.size) {
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
    }
}