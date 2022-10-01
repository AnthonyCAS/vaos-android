package com.android.vaos.ui.components.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.android.vaos.R
import com.android.vaos.ui.theme.AppTheme

@Composable
fun ScreenWithTopBar(
    headerTitle: String,
    modifier: Modifier = Modifier,
    headerSubtitle: String? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable (RowScope.() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth(),
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = headerTitle,
                                style = AppTheme.typography.bodyLRegular,
                                color = AppTheme.colors.colorGray7,
                                overflow = TextOverflow.Clip
                            )
                            headerSubtitle?.let {
                                Text(
                                    text = headerSubtitle,
                                    style = AppTheme.typography.bodyMRegular,
                                    color = AppTheme.colors.colorGray6,
                                    overflow = TextOverflow.Clip
                                )
                            }
                        }
                    },
                    navigationIcon = {
                        navigationIcon?.let { navigationIcon() }
                    },
                    actions = {
                        actions?.let { actions() }
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = AppTheme.colors.colorWhite,
                        actionIconContentColor = AppTheme.colors.colorGray7
                    )
                )
                Divider(
                    modifier = Modifier
                        .height(AppTheme.dimens.size1)
                        .fillMaxWidth(),
                    color = AppTheme.colors.colorGray3
                )
            }
        },
        containerColor = AppTheme.colors.colorWhite,
        content = content
    )
}

@Preview
@Composable
fun ScreenWithTopBarPreview() {
    AppTheme {
        ScreenWithTopBar(
            headerTitle = "Title",
            content = {}
        )
    }
}

@Preview
@Composable
fun ScreenWithTopBarPreviewV2() {
    AppTheme {
        ScreenWithTopBar(
            headerTitle = "Title",
            navigationIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(
                            id = R.string.back
                        ),
                        tint = AppTheme.colors.colorPrimary5
                    )
                }
            },
            content = {}
        )
    }
}

@Preview
@Composable
fun ScreenWithTopBarPreviewV3() {
    AppTheme {
        ScreenWithTopBar(
            headerTitle = "Title",
            navigationIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = stringResource(
                            id = R.string.back
                        ),
                        tint = AppTheme.colors.colorPrimary5
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = AppTheme.colors.colorPrimary5
                    )
                }
            },
            content = {}
        )
    }
}
