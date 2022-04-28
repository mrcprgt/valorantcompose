package com.mrcprgt.valorantcompose.presentation

 ;import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mrcprgt.valorantcompose.domain.model.Agent

@Composable
fun AgentItem(
    agent: Agent,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(agent.displayIcon)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(CircleShape)
                        .fillMaxWidth(0.15f)
                )
                Column() {
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
                    Text(
                        text = agent.role.displayName,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = agent.description,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .padding(start = 8.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}

