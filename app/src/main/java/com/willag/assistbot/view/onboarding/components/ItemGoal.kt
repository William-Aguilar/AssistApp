package com.willag.assistbot.view.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.willag.assistbot.view.core.components.AssistBotText

@Composable
fun ItemGoal(item: GoalItem) {
    Card(
        modifier = Modifier.size(100.dp),
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(item.icon),
                contentDescription = item.description,
                modifier = Modifier.size(50.dp),
            )
            AssistBotText(
                text = item.title,
                modifier = Modifier.padding(bottom = 10.dp),
            )
        }
    }
}