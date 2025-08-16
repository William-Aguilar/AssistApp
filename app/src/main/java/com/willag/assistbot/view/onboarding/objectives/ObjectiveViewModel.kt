package com.willag.assistbot.view.onboarding.objectives

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.willag.assistbot.R
import com.willag.assistbot.view.onboarding.components.GoalItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ObjectiveViewModel @Inject constructor() : ViewModel() {
    val goals = mutableStateListOf(
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Aprobar un examen", description = "Descripción 1"),
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Viajar", description = "Descripción 2"),
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Mejorar conversación", description = "Descripción 3"),
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Trabajo", description = "Descripción 4"),
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Cultura general", description = "Descripción 5"),
        GoalItem(icon = R.drawable.ic_launcher_foreground, title = "Otro", description = "Descripción 6")
    )

    fun toggleGoalSelection(index: Int) {
        goals[index] = goals[index].copy(isSelected = !goals[index].isSelected)
    }
}