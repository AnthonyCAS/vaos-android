package com.android.vaos.ux.welcome

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.vaos.ui.components.buttons.DefaultIconButton
import com.android.vaos.ui.components.buttons.PrimaryButton
import com.android.vaos.ui.components.input.InputField
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.ABSOLUTE_WEIGHT
import com.android.vaos.util.ext.applyIf
import com.android.vaos.util.navigation.HandleNavigation
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun WelcomeScreen(
    navController: NavController,
    homeViewModel: WelcomeViewModel = hiltViewModel()
) {
    WelcomeScreenContent(homeViewModel.starterUiState)
    HandleNavigation(viewModelNav = homeViewModel, navController = navController)
}

@Composable
fun WelcomeScreenContent(
    state: WelcomeUiState
) {
    val focusManager = LocalFocusManager.current
    val userName by state.userName.collectAsState()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            focusManager.clearFocus()
                        }
                    )
                }
                .padding(paddingValues)
                .padding(top = 40.dp)
                .imePadding()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingSmall),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Va’os",
                style = AppTheme.typography.displayMRegular,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = AppTheme.dimens.spacingSmall
                    )
                    .fillMaxWidth()
            )
            Text(
                text = "This application will help you to have a great time with your friends",
                style = AppTheme.typography.bodyLRegular,
                color = Color.Black,
                modifier = Modifier
                    .padding(
                        horizontal = AppTheme.dimens.spacingSmall
                    )
                    .fillMaxWidth()
            )
            val safeUserName = userName.orEmpty()
            InputField(
                text = safeUserName,
                modifier = Modifier
                    .padding(
                        horizontal = AppTheme.dimens.spacingSmall
                    )
                    .fillMaxWidth(),
                enabled = true,
                label = {
                    val spacingXSmall = AppTheme.dimens.spacingXSmall
                    Text(
                        text = "My name",
                        style = AppTheme.typography.bodySRegular,
                        modifier = Modifier
                            .applyIf(safeUserName.isNotEmpty()) {
                                padding(
                                    top = spacingXSmall
                                )
                            }
                    )
                },
                trailIcon = {
                    if (safeUserName.isNotBlank()) {
                        DefaultIconButton(
                            imageVector = Icons.Outlined.Close,
                            tintColor = AppTheme.colors.colorGray4,
                            onClick = {
                                state.mutateUserName(null)
                            }
                        )
                    }
                }
            ) {
                state.mutateUserName(it)
            }

            InputField(
                text = "",
                modifier = Modifier
                    .padding(
                        horizontal = AppTheme.dimens.spacingSmall
                    )
                    .fillMaxWidth(),
                enabled = false,
                label = {
                    val spacingXSmall = AppTheme.dimens.spacingXSmall
                    Text(
                        text = "Select an office",
                        style = AppTheme.typography.bodySRegular,
                    )
                },
                trailIcon = {
                    DefaultIconButton(
                        imageVector = Icons.Outlined.ExpandMore,
                        tintColor = AppTheme.colors.colorGray4,
                        onClick = {}
                    )
                },
                onValueChanged = {}
            )
            Spacer(
                modifier = Modifier
                    .weight(ABSOLUTE_WEIGHT)
            )
            PrimaryButton(
                text = "Let’s go!",
                enabled = !safeUserName.isNullOrBlank(),
                onClick = state.navigateToHome,
                modifier = Modifier
                    .padding(
                        all = AppTheme.dimens.spacingSmall
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
    val isAGuest: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val userData = MutableStateFlow(null)
    val state = WelcomeUiState(
        isLoading = isLoading,
        isAGuest = isAGuest,
        userData = userData,
        userName = MutableStateFlow(""),
        mutateUserName = {},
        navigateToHome = {}
    )

    AppTheme {
        WelcomeScreenContent(
            state = state
        )
    }
}
