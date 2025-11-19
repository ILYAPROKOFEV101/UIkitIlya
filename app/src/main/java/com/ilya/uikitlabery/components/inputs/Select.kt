package com.ilya.uikitlabery.components.inputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

/**
 * Элемент данных для селекта
 */
data class SelectItem(
    val id: String,
    val text: String,
    val emoji: String? = null,
    val data: Any? = null
)

/**
 * Селект (выпадающий список)
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectField(
    selectedItem: SelectItem?,
    onItemSelected: (SelectItem) -> Unit,
    items: List<SelectItem>,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = "Выберите...",
    showClearButton: Boolean = false,
    onClearClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    backgroundColor: Color = Neutral100,
    borderColor: Color = Border
) {
    var expanded by remember { mutableStateOf(false) }
    
    Column(modifier = modifier) {
        label?.let {
            Text(
                text = it,
                style = BodyMedium,
                color = Neutral700,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        Box {
            OutlinedTextField(
                value = selectedItem?.let { 
                    if (it.emoji != null) {
                        "${it.emoji} ${it.text}"
                    } else {
                        it.text
                    }
                } ?: "",
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(enabled = enabled) { expanded = true },
                placeholder = {
                    Text(
                        text = placeholder,
                        style = BodyMedium,
                        color = Neutral500
                    )
                },
                trailingIcon = {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        if (showClearButton && selectedItem != null) {
                            IconButton(onClick = { onClearClick?.invoke() }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear",
                                    tint = Neutral500,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Dropdown",
                            tint = Neutral500
                        )
                    }
                },
                enabled = false,
                readOnly = true,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledBorderColor = borderColor,
                    disabledContainerColor = backgroundColor,
                    disabledTextColor = OnSurface,
                    disabledPlaceholderColor = Neutral500
                ),
                shape = RoundedCornerShape(12.dp)
            )
            
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                items.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                item.emoji?.let {
                                    Text(text = it, style = TitleLarge)
                                }
                                Text(
                                    text = item.text,
                                    style = BodyMedium
                                )
                            }
                        },
                        onClick = {
                            onItemSelected(item)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}

/**
 * Датапикер (упрощенная версия)
 */
@Composable
fun DatePickerField(
    selectedDate: String?,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String = "Выберите дату",
    enabled: Boolean = true
) {
    var showDatePicker by remember { mutableStateOf(false) }
    
    Column(modifier = modifier) {
        label?.let {
            Text(
                text = it,
                style = BodyMedium,
                color = Neutral700,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
        
        OutlinedTextField(
            value = selectedDate ?: "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = enabled) { showDatePicker = true },
            placeholder = {
                Text(
                    text = placeholder,
                    style = BodyMedium,
                    color = Neutral500
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Date picker",
                    tint = Neutral500
                )
            },
            enabled = false,
            readOnly = true,
            colors = OutlinedTextFieldDefaults.colors(
                disabledBorderColor = Border,
                disabledContainerColor = Neutral100,
                disabledTextColor = OnSurface,
                disabledPlaceholderColor = Neutral500
            ),
            shape = RoundedCornerShape(12.dp)
        )
    }
    
    // Здесь можно добавить DatePickerDialog
    // Для полной реализации нужен DatePickerDialog из Material3
}

