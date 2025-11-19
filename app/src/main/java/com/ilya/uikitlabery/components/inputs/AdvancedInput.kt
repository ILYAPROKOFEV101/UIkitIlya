package com.ilya.uikitlabery.components.inputs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

/**
 * Расширенное поле ввода с поддержкой иконок и различных состояний
 */
@Composable
fun AdvancedInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = "",
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    showClearButton: Boolean = false,
    onClearClick: (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    backgroundColor: Color = Neutral100,
    borderColor: Color = Border,
    focusedBorderColor: Color = Primary
) {
    Column(modifier = modifier) {
        label?.let {
            Text(
                text = it,
                style = BodyMedium,
                color = if (isError) Error else Neutral700,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(
                    text = placeholder,
                    style = BodyMedium,
                    color = Neutral500
                )
            },
            leadingIcon = leadingIcon?.let {
                {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        tint = Neutral500
                    )
                }
            },
            trailingIcon = if (showClearButton && value.isNotEmpty()) {
                {
                    IconButton(onClick = { onClearClick?.invoke() ?: onValueChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Neutral500
                        )
                    }
                }
            } else if (trailingIcon != null) {
                {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = null,
                        tint = Neutral500
                    )
                }
            } else null,
            isError = isError,
            enabled = enabled,
            singleLine = singleLine,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (isError) Error else focusedBorderColor,
                unfocusedBorderColor = if (isError) Error else borderColor,
                errorBorderColor = Error,
                focusedLabelColor = if (isError) Error else Primary,
                unfocusedLabelColor = Neutral600,
                errorLabelColor = Error,
                focusedTextColor = OnSurface,
                unfocusedTextColor = OnSurface,
                errorTextColor = OnSurface,
                focusedPlaceholderColor = Neutral500,
                unfocusedPlaceholderColor = Neutral500,
                errorPlaceholderColor = Neutral500,
                focusedContainerColor = backgroundColor,
                unfocusedContainerColor = backgroundColor,
                disabledContainerColor = backgroundColor.copy(alpha = 0.5f)
            ),
            shape = RoundedCornerShape(12.dp)
        )
        
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = Error,
                style = BodySmall,
                modifier = Modifier.padding(top = 4.dp, start = 16.dp)
            )
        }
    }
}

/**
 * Маленькое числовое поле ввода
 */
@Composable
fun SmallNumberInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "0",
    enabled: Boolean = true
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.all { it.isDigit() }) {
                onValueChange(newValue)
            }
        },
        modifier = modifier.width(60.dp),
        placeholder = {
            Text(
                text = placeholder,
                style = BodyMedium,
                color = Neutral500
            )
        },
        enabled = enabled,
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Primary,
            unfocusedBorderColor = Border,
            focusedTextColor = OnSurface,
            unfocusedTextColor = OnSurface,
            focusedPlaceholderColor = Neutral500,
            unfocusedPlaceholderColor = Neutral500,
            focusedContainerColor = Neutral100,
            unfocusedContainerColor = Neutral100
        ),
        shape = RoundedCornerShape(8.dp),
        textStyle = BodyMedium
    )
}

