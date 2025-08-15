package com.willag.assistbot.view.onboarding

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OnBoardingScreen() {
    val pageState = rememberPagerState(
        initialPage = 0,
        pageCount = { 3 }
    )
    Scaffold { paddingValues ->
        HorizontalPager(
            modifier = Modifier.padding(paddingValues),
            state = pageState
        ) { page ->
            when (page) {
                /*0 -> ObjectiveScreen()
                1 -> FeaturesScreen()
                2 -> GetStartedScreen()*/
            }
        }
    }
}