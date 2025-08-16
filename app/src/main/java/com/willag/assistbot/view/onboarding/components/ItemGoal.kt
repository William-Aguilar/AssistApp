package com.willag.assistbot.view.onboarding.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.willag.assistbot.view.core.components.AssistBotText

@Composable
fun ItemGoal(item: GoalItem, onSelected: () -> Unit) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable { onSelected() },
        border = if (item.isSelected) BorderStroke(
            2.dp,
            MaterialTheme.colorScheme.primary
        ) else null
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