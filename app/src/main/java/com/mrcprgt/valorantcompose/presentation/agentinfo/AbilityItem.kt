package com.mrcprgt.valorantcompose.presentation.agentinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Dimension
import com.mrcprgt.valorantcompose.domain.model.Agent

@Composable
fun AbilityItem(
    ability: Agent.Ability,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .height(64.dp)
                        .width(64.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(ability.displayIcon)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .background(Color.Black)
                            .clip(CircleShape)
                    )
                }
                Column() {
                    Text(
                        text = ability.displayName,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.onBackground,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = ability.description,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

