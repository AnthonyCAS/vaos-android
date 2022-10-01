package com.android.vaos.ui.components.topbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.android.vaos.R
import com.android.vaos.util.EMPTY_STRING
import com.android.vaos.ui.theme.AppTheme

@Composable
fun SearchTopBar(
    searchInputValue: String,
    onNavigateBack: () -> Unit,
    onInputValueChange: (String) -> Unit,
    onCancel: () -> Unit,
    modifier: Modifier = Modifier,
    placeholderValue: String = stringResource(id = R.string.search),
    navigationIconTintColor: Color = AppTheme.colors.colorPrimary5
) {
    SmallTopAppBar(
        modifier = modifier,
        title = {
            SearchDataInput(
                searchInputValue = searchInputValue,
                onInputValueChange = onInputValueChange,
                onCancel = onCancel,
                placeholderValue = placeholderValue,
                modifier = Modifier
                    .padding(
                        end = AppTheme.dimens.spacingSmall
                    )
            )
        },
        navigationIcon = {
            IconButton(
                modifier = Modifier
                    .testTag("navigateBackButton"),
                onClick = onNavigateBack
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.back),
                    tint = navigationIconTintColor
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = AppTheme.colors.colorWhite,
            actionIconContentColor = AppTheme.colors.colorGray7
        )
    )
}

@Composable
fun SearchDataInput(
    searchInputValue: String?,
    onInputValueChange: (String) -> Unit,
    onCancel: () -> Unit,
    placeholderValue: String,
    modifier: Modifier = Modifier
) {
    val localFocus = LocalFocusManager.current
    TextField(
        modifier = modifier
            .fillMaxWidth()
            .height(AppTheme.dimens.searchBarHeight),
        value = searchInputValue ?: EMPTY_STRING,
        shape = RoundedCornerShape(AppTheme.dimens.searchBarCornerRadius),
        onValueChange = onInputValueChange,
        placeholder = {
            Text(
                text = placeholderValue,
                style = AppTheme.typography.bodyMRegular,
                color = AppTheme.colors.colorGray4
            )
        },
        textStyle = AppTheme.typography.bodyMRegular,
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(id = R.string.search),
                tint = AppTheme.colors.colorGray7,
            )
        },
        trailingIcon = {
            if (searchInputValue != null && searchInputValue.isNotBlank()) {
                IconButton(
                    onClick = {
                        if (searchInputValue.isNotEmpty()) {
                            onInputValueChange(EMPTY_STRING)
                        } else {
                            onCancel()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Cancel,
                        contentDescription = stringResource(id = R.string.close),
                        tint = AppTheme.colors.colorGray7
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                localFocus.clearFocus()
            }
        ),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = AppTheme.colors.colorWhite,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            textColor = AppTheme.colors.colorGray7,
            focusedTrailingIconColor = AppTheme.colors.colorGray7
        )
    )
}

@Composable
fun ScreenWithSearchTopBar(
    searchInputValue: String,
    onNavigateBack: () -> Unit,
    onCancel: () -> Unit,
    onInputValueChange: (String) -> Unit,
    dividerColor: Color = AppTheme.colors.colorGray4,
    placeholderValue: String = stringResource(id = R.string.search),
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth(),
        topBar = {
            Column {
                SearchTopBar(
                    searchInputValue = searchInputValue,
                    onNavigateBack = onNavigateBack,
                    onInputValueChange = onInputValueChange,
                    onCancel = onCancel,
                    placeholderValue = placeholderValue,
                    navigationIconTintColor = AppTheme.colors.colorPrimary5
                )
                Divider(
                    modifier = Modifier
                        .height(AppTheme.dimens.size1)
                        .fillMaxWidth(),
                    color = dividerColor
                )
            }
        },
        containerColor = AppTheme.colors.colorWhite,
        content = content
    )
}

@Preview
@Composable
fun SearchTopBarPreview() {
    var searchInputValue by remember {
        mutableStateOf("")
    }
    AppTheme(darkTheme = false) {
        SearchTopBar(
            searchInputValue = searchInputValue,
            onNavigateBack = { },
            onInputValueChange = { searchInputValue = it },
            onCancel = { searchInputValue = "" }
        )
    }
}

@Preview
@Composable
fun SearchDataInputPreview() {
    AppTheme(darkTheme = false) {
        SearchDataInput(
            searchInputValue = "",
            onCancel = { },
            onInputValueChange = { },
            placeholderValue = "Location"
        )
    }
}

@Preview
@Composable
fun ScreenWithSearchTopBarPreview() {
    AppTheme {
        ScreenWithSearchTopBar(
            searchInputValue = "",
            onInputValueChange = {},
            onNavigateBack = {},
            onCancel = {},
            content = {}
        )
    }
}
