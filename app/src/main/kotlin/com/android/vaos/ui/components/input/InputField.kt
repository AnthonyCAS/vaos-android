package com.android.vaos.ui.components.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.Dp
import com.android.vaos.ui.components.buttons.DefaultIconButton
import com.android.vaos.ui.theme.AppTheme
import com.android.vaos.util.EMPTY_STRING
import com.android.vaos.util.compose.BooleanPreviewParameter
import com.android.vaos.util.ext.applyIf

@Composable
fun InputField(
    text: String,
    modifier: Modifier = Modifier,
    errorText: String? = null,
    keyboardOptions: KeyboardOptions? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cornerBorderRadius: Dp? = null,
    enabled: Boolean = true,
    helper: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    label: @Composable (() -> Unit)? = null,
    trailIcon: @Composable (() -> Unit)? = null,
    onValueChanged: (String) -> Unit
) {
    val borderRadius = cornerBorderRadius ?: AppTheme.dimens.largeCornerRadius
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused = interactionSource.collectIsFocusedAsState().value

    val containerColor: Color
    val borderColor: Color

    when {
        errorText != null -> {
            containerColor = AppTheme.colors.colorWhite
            borderColor = AppTheme.colors.colorError4
        }
        isFocused -> {
            containerColor = AppTheme.colors.colorWhite
            borderColor = AppTheme.colors.colorGray7
        }
        else -> {
            containerColor = AppTheme.colors.colorGray2
            borderColor = Color.Transparent
        }
    }
    val colors = TextFieldDefaults.textFieldColors(
        textColor = if (isFocused) {
            AppTheme.colors.colorGray7
        } else {
            AppTheme.colors.colorGray6
        },
        disabledTextColor = AppTheme.colors.colorGray4,
        disabledTrailingIconColor = AppTheme.colors.colorGray4,
        unfocusedTrailingIconColor = AppTheme.colors.colorGray4,
        focusedTrailingIconColor = AppTheme.colors.colorGray4,
        errorTrailingIconColor = AppTheme.colors.colorGray4,
        containerColor = containerColor,
        selectionColors = TextSelectionColors(
            handleColor = AppTheme.colors.colorGray3,
            backgroundColor = AppTheme.colors.colorGray3
        ),
        cursorColor = AppTheme.colors.colorGray7,
        errorCursorColor = AppTheme.colors.colorGray7,
        errorLabelColor = AppTheme.colors.colorError4,
        unfocusedLabelColor = AppTheme.colors.colorGray3,
        focusedLabelColor = AppTheme.colors.colorGray3,
        disabledLabelColor = AppTheme.colors.colorGray3,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
        errorIndicatorColor = Color.Transparent,
        placeholderColor = AppTheme.colors.colorGray4,
        disabledPlaceholderColor = AppTheme.colors.colorGray3
    )

    Column(
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingTiny),
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        if (helper != null) {
            helper()
        }

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    shape = RoundedCornerShape(borderRadius),
                    border = BorderStroke(
                        width = AppTheme.dimens.smallStrokeWidth,
                        color = borderColor
                    )
                )
                .focusRequester(focusRequester),
            value = text,
            label = label,
            placeholder = placeholder,
            interactionSource = interactionSource,
            colors = colors,
            onValueChange = onValueChanged,
            shape = RoundedCornerShape(borderRadius),
            textStyle = AppTheme.typography.bodyMRegular,
            singleLine = true,
            isError = errorText != null,
            enabled = enabled,
            trailingIcon = trailIcon,
            keyboardOptions = keyboardOptions ?: KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    focusRequester.freeFocus()
                }
            ),
            visualTransformation = visualTransformation
        )
        if (errorText != null) {
            Text(
                text = errorText,
                style = AppTheme.typography.bodySRegular,
                color = AppTheme.colors.colorError4,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = AppTheme.dimens.spacingTiny)
            )
        }
    }
}

@Composable
fun HelperText(
    text: String,
    modifier: Modifier = Modifier,
    isRequired: Boolean = false
) {
    Text(
        text = buildAnnotatedString {
            append(text)
            if (isRequired) {
                withStyle(
                    style = AppTheme.typography.bodyMRegular.toSpanStyle().copy(
                        color = AppTheme.colors.colorError4
                    )
                ) {
                    append(" *")
                }
            }
        },
        style = AppTheme.typography.bodyXSRegular,
        color = AppTheme.colors.colorGray7,
        modifier = modifier
    )
}

@Preview
@Composable
fun HelperTextPreview(
    @PreviewParameter(BooleanPreviewParameter::class) isRequired: Boolean
) {
    AppTheme {
        HelperText(
            text = "City",
            isRequired = isRequired
        )
    }
}

@Preview
@Composable
@Suppress("MagicNumber")
fun InputFieldPreview(
    @PreviewParameter(BooleanPreviewParameter::class) enabled: Boolean
) {
    AppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimens.spacingXSmall),
            modifier = Modifier
                .background(AppTheme.colors.colorWhite)
                .verticalScroll(rememberScrollState())
        ) {
            var inputValue by remember {
                mutableStateOf(EMPTY_STRING)
            }
            var errorTextValue: String? by remember {
                mutableStateOf(null)
            }
            InputField(
                text = inputValue,
                errorText = errorTextValue,
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled,
                label = {
                    val spacingXSmall = AppTheme.dimens.spacingXSmall
                    Text(
                        text = "Phone Number",
                        style = AppTheme.typography.bodyMRegular,
                        modifier = Modifier
                            .applyIf(inputValue.isNotEmpty()) {
                                padding(
                                    top = spacingXSmall
                                )
                            }
                    )
                },
                trailIcon = {
                    if (inputValue.isNotBlank()) {
                        DefaultIconButton(
                            imageVector = Icons.Outlined.Close,
                            onClick = {}
                        )
                    }
                }
            ) {
                inputValue = it
                errorTextValue = if (inputValue.length > 3) "Invalid text" else null
            }

            InputField(
                text = "text with helper and no errors",
                helper = {
                    HelperText(
                        text = "City",
                        isRequired = true
                    )
                },
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled
            ) {}

            InputField(
                text = "943-561-678",
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled,
                label = {
                    Text(
                        text = "Phone Number",
                        style = AppTheme.typography.bodyMRegular,
                        modifier = Modifier
                            .padding(top = AppTheme.dimens.spacingXSmall)
                    )
                }
            ) {}

            InputField(
                text = "text with errors",
                errorText = "Invalid text",
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled
            ) {}

            InputField(
                text = "text with helper and errors",
                errorText = "Invalid text",
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled,
                trailIcon = {
                    DefaultIconButton(
                        imageVector = Icons.Outlined.Close,
                        onClick = {}
                    )
                },
                label = {
                    Text(
                        text = "Phone Number",
                        style = AppTheme.typography.bodyMRegular,
                        modifier = Modifier
                            .padding(top = AppTheme.dimens.spacingXSmall)
                    )
                },
                helper = {
                    HelperText(
                        text = "State",
                        isRequired = true
                    )
                }
            ) {}

            InputField(
                text = "999-999-999",
                errorText = "Uh oh! There was an error! Try Again",
                modifier = Modifier
                    .padding(AppTheme.dimens.spacingMed)
                    .fillMaxWidth(),
                enabled = enabled,
                label = {
                    Text(
                        text = "Phone Number",
                        style = AppTheme.typography.bodyMRegular,
                        modifier = Modifier
                            .padding(top = AppTheme.dimens.spacingXSmall)
                    )
                },
                trailIcon = {
                    DefaultIconButton(
                        imageVector = Icons.Outlined.Close,
                        onClick = {}
                    )
                }
            ) {}
        }
    }
}
