package com.ilya.uikitlabery.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

/**
 * Компонент поиска
 */
@Composable
fun SearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Искать описание",
    showCancelButton: Boolean = false,
    onCancelClick: (() -> Unit)? = null,
    onSearchClick: (() -> Unit)? = null,
    enabled: Boolean = true
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1f),
            placeholder = {
                Text(
                    text = placeholder,
                    style = BodyMedium,
                    color = Neutral500
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Neutral500
                )
            },
            trailingIcon = if (value.isNotEmpty()) {
                {
                    IconButton(onClick = { onValueChange("") }) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Neutral500,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            } else null,
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
                unfocusedContainerColor = Neutral100,
                disabledContainerColor = Neutral100.copy(alpha = 0.5f)
            ),
            shape = RoundedCornerShape(12.dp),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClick?.invoke() }
            )
        )
        
        if (showCancelButton) {
            TextButton(onClick = { onCancelClick?.invoke() ?: onValueChange("") }) {
                Text(
                    text = "Отменить",
                    style = BodyMedium,
                    color = Primary
                )
            }
        }
    }
}

