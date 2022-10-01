package com.android.vaos.ux.starter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.vaos.R
import com.android.vaos.ui.components.buttons.SecondaryButton
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.navigation.HandleNavigation
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun StarterScreen(
    navController: NavController,
    homeViewModel: StarterViewModel = hiltViewModel()
) {
    StarterScreenContent(homeViewModel.starterUiState)
    HandleNavigation(viewModelNav = homeViewModel, navController = navController)
}

@Composable
fun StarterScreenContent(
    state: StarterUiState
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_starter_wave_top),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_starter_wave_bottom),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_girl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 22.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_vaos),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(
                        end = 40.dp,
                        bottom = 42.dp
                    )
            )
            SecondaryButton(
                text = "Start my experience",
                enabled = true,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = AppTheme.colors.colorWhite,
                    disabledContentColor = AppTheme.colors.colorPrimary3,
                    disabledContainerColor = Color.Transparent
                ),
                onClick = state.navigateToWelcomeScreen,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = AppTheme.dimens.spacingSmall,
                        end = AppTheme.dimens.spacingSmall,
                        bottom = 42.dp
                    )
            )
        }
    }
}

@Preview(
    showBackground = true,
    name = "HomeScreen guest user"
)
@Composable
fun StarterScreenPreview() {
    val isLoading = MutableStateFlow(false)
    val state = StarterUiState(
        isLoading = isLoading,
        navigateToWelcomeScreen = {}
    )

    AppTheme {
        StarterScreenContent(
            state = state
        )
    }
}
