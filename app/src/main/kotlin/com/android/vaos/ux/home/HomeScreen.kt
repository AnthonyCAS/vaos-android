package com.android.vaos.ux.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.android.vaos.R
import com.android.vaos.ui.components.buttons.PrimaryButton
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.ABSOLUTE_WEIGHT
import com.android.vaos.util.navigation.HandleNavigation
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenContent(homeViewModel.homeUiState)
    HandleNavigation(viewModelNav = homeViewModel, navController = navController)
}

@Composable
fun HomeScreenContent(
    state: HomeUiState
) {
    val scope = rememberCoroutineScope()
    val isLoading by state.isLoading.collectAsState()
    val userName by state.userName.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 40.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingSmall),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(
                        horizontal = AppTheme.dimens.spacingSmall
                    )
            ) {
                Column(
                    modifier = Modifier
                        .weight(ABSOLUTE_WEIGHT)
                ) {
                    Text(
                        text = "Welcome Back",
                        style = AppTheme.typography.bodyLRegular,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier
                            .wrapContentWidth()
                    )
                    Text(
                        text = userName,
                        style = AppTheme.typography.bodyMRegular,
                        color = Color.Black,
                        modifier = Modifier
                            .wrapContentWidth()
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
            Row(
                modifier = Modifier
                    .padding(
                        start = AppTheme.dimens.spacingSmall
                    )
                    .horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PrimaryButton(
                    text = "All Categories",
                    enabled = true,
                    onClick = {},
                    contentCustom = {
                        Text(
                            text = "All Categories",
                            style = AppTheme.typography.bodySRegular
                        )
                    }
                )
                OutlinedButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = AppTheme.colors.colorWhite,
                        disabledContentColor = AppTheme.colors.colorPrimary3,
                        disabledContainerColor = Color.Transparent
                    ),
                    border = BorderStroke(
                        width = AppTheme.dimens.smallStrokeWidth,
                        color = AppTheme.colors.colorPrimary4
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Food",
                            style = AppTheme.typography.bodySRegular,
                            color = AppTheme.colors.colorPrimary4
                        )
                    }
                }
                OutlinedButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = AppTheme.colors.colorWhite,
                        disabledContentColor = AppTheme.colors.colorPrimary3,
                        disabledContainerColor = Color.Transparent
                    ),
                    border = BorderStroke(
                        width = AppTheme.dimens.smallStrokeWidth,
                        color = AppTheme.colors.colorPrimary4
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Sports",
                            style = AppTheme.typography.bodySRegular,
                            color = AppTheme.colors.colorPrimary4
                        )
                    }
                }
                OutlinedButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = AppTheme.colors.colorWhite,
                        disabledContentColor = AppTheme.colors.colorPrimary3,
                        disabledContainerColor = Color.Transparent
                    ),
                    border = BorderStroke(
                        width = AppTheme.dimens.smallStrokeWidth,
                        color = AppTheme.colors.colorPrimary4
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Games",
                            style = AppTheme.typography.bodySRegular,
                            color = AppTheme.colors.colorPrimary4
                        )
                    }
                }
                OutlinedButton(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = AppTheme.colors.colorWhite,
                        disabledContentColor = AppTheme.colors.colorPrimary3,
                        disabledContainerColor = Color.Transparent
                    ),
                    border = BorderStroke(
                        width = AppTheme.dimens.smallStrokeWidth,
                        color = AppTheme.colors.colorPrimary4
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Concerts",
                            style = AppTheme.typography.bodySRegular,
                            color = AppTheme.colors.colorPrimary4
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(
                        top = 32.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cooking),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(236.dp)
                    )
                }
                Card(
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.concert),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(236.dp)
                    )
                }
                Card(
                    onClick = {}
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sport),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(236.dp)
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "HomeScreen guest user"
)
@Composable
fun HomeScreenGuestUserPreview() {
    val isLoading = MutableStateFlow(false)
    val state = HomeUiState(
        isLoading = isLoading,
        userName = MutableStateFlow("Anthony")
    )

    AppTheme {
        HomeScreenContent(
            state = state
        )
    }
}
