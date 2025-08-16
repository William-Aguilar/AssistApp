package com.willag.assistbot.view.onboarding.objectives

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.willag.assistbot.R
import com.willag.assistbot.view.core.components.AssistBotButton
import com.willag.assistbot.view.core.components.AssistBotText
import com.willag.assistbot.view.core.components.AssistBotTextFieldSecond
import com.willag.assistbot.view.onboarding.components.ItemGoal

@Composable
fun ObjectiveScreen(
    objectiveViewModel: ObjectiveViewModel = hiltViewModel()
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.weight(0.25f))
            AssistBotText(
                text = stringResource(R.string.objectives_screen_header_title),
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(Modifier.height(16.dp))
            AssistBotText(
                text = stringResource(R.string.objectives_screen_header_description),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(32.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(objectiveViewModel.goals.size) { index ->
                    ItemGoal(item = objectiveViewModel.goals[index]){
                        objectiveViewModel.toggleGoalSelection(index)
                    }
                }
            }
            AssistBotTextFieldSecond(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                value = "",
                onValueChange = {  },
                labelText = stringResource(R.string.objectives_screen_textfield_objective),
                singleLine = true,
            )
            Spacer(Modifier.weight(0.65f))
            AssistBotButton(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                text = stringResource(R.string.objectives_screen_button_continue),
                onClick = { /*TODO*/ },
                enabled = false
            )
            Spacer(Modifier.weight(0.35f))
        }
    }
}