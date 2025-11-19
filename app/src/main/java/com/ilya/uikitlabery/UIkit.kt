package com.ilya.uikitlabery

import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// ===== КНОПКИ =====
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    loading: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        enabled = enabled && !loading,
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = Color.White,
            disabledContainerColor = Neutral300,
            disabledContentColor = Neutral600
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                color = Color.White,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                style = LabelLarge
            )
        }
    }
}

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Primary,
            disabledContentColor = Neutral600
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            style = LabelLarge
        )
    }
}

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    textColor: Color = Primary
) {
    androidx.compose.material3.TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            style = LabelLarge.copy(color = textColor)
        )
    }
}

// ===== КАРТОЧКИ =====
@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Surface
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            content = content
        )
    }
}

@Composable
fun OutlinedCard(
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Surface,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(16.dp),
            content = content
        )
    }
}

// ===== ПОЛЯ ВВОДА =====
@Composable
fun PrimaryTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String? = null,
    placeholder: String? = null,
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            label = label?.let { { Text(it) } },
            placeholder = placeholder?.let { { Text(it) } },
            isError = isError,
            enabled = enabled,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Primary,
                unfocusedBorderColor = Border,
                errorBorderColor = Error,
                focusedLabelColor = Primary,
                unfocusedLabelColor = Neutral600,
                errorLabelColor = Error,
                focusedTextColor = OnSurface,
                unfocusedTextColor = OnSurface,
                errorTextColor = OnSurface,
                focusedPlaceholderColor = Neutral500,
                unfocusedPlaceholderColor = Neutral500,
                errorPlaceholderColor = Neutral500
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

// ===== СТАТУС =====
@Composable
fun StatusChip(
    text: String,
    status: StatusType,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (status) {
        StatusType.Success -> Success.copy(alpha = 0.1f)
        StatusType.Warning -> Warning.copy(alpha = 0.1f)
        StatusType.Error -> Error.copy(alpha = 0.1f)
        StatusType.Info -> Info.copy(alpha = 0.1f)
        StatusType.Neutral -> Neutral200
    }

    val textColor = when (status) {
        StatusType.Success -> Success
        StatusType.Warning -> Warning
        StatusType.Error -> Error
        StatusType.Info -> Info
        StatusType.Neutral -> Neutral700
    }

    Surface(
        modifier = modifier,
        color = backgroundColor,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = textColor,
            style = LabelMedium,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun ProgressIndicator(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = Primary,
    backgroundColor: Color = Neutral200
) {
    LinearProgressIndicator(
        progress = { progress },
        modifier = modifier.fillMaxWidth(),
        color = color,
        trackColor = backgroundColor,
        strokeCap = androidx.compose.ui.graphics.StrokeCap.Round
    )
}

enum class StatusType {
    Success,
    Warning,
    Error,
    Info,
    Neutral
}

// ===== МЕДИЦИНСКИЕ КОМПОНЕНТЫ =====
@Composable
fun ResultTableCell(
    parameterName: String,
    value: String,
    range: String,
    valueColor: Color = OnSurface,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = Surface
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Parameter name
            Text(
                text = parameterName,
                style = BodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = OnSurface,
                modifier = Modifier.weight(1f)
            )
            
            // Value and range
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = value,
                    style = BodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = valueColor
                )
                
                Text(
                    text = range,
                    style = BodySmall,
                    color = Neutral600
                )
                
                // Arrow icon
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_media_play),
                    contentDescription = null,
                    tint = Neutral500,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

// ===== КОМПОНЕНТЫ ЗАКАЗОВ =====
@Composable
fun OrderCell(
    itemName: String,
    price: String,
    isSelected: Boolean = false,
    isEnabled: Boolean = true,
    modifier: Modifier = Modifier,
    onItemClick: (() -> Unit)? = null
) {
    val backgroundColor = if (isSelected) Primary.copy(alpha = 0.1f) else Surface
    val textColor = if (isEnabled) OnSurface else Neutral400
    val priceColor = if (isEnabled) OnSurface else Neutral400
    
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onItemClick != null && isEnabled) {
                    Modifier.clickable { onItemClick() }
                } else {
                    Modifier
                }
            ),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(5.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.weight(1f)
            ) {
                // Checkbox
                Checkbox(
                    checked = isSelected,
                    onCheckedChange = null,
                    enabled = isEnabled,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary,
                        uncheckedColor = Neutral400,
                        checkmarkColor = Color.White
                    )
                )
                
                // Item name
                Text(
                    text = itemName,
                    style = BodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = textColor,
                    modifier = Modifier.weight(1f)
                )
            }
            
            // Price
            Text(
                text = price,
                style = BodyMedium.copy(
                    fontWeight = FontWeight.Medium
                ),
                color = priceColor
            )
        }
    }
}

@Composable
fun OrderCardOpened(
    orderNumber: String,
    totalPrice: String,
    date: String,
    status: String,
    statusColor: Color = Success,
    items: List<OrderItemDetail>,
    modifier: Modifier = Modifier,
    onViewReceipt: (() -> Unit)? = null,
    onHelp: (() -> Unit)? = null,
    onCancelOrder: (() -> Unit)? = null
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Surface
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column {
                    Text(
                        text = "Заказ № $orderNumber",
                        style = TitleMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = OnSurface
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = date,
                        style = BodySmall,
                        color = Neutral600
                    )
                }
                
                Text(
                    text = totalPrice,
                    style = TitleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = OnSurface
                )
            }
            
            // Status
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(
                            color = statusColor,
                            shape = RoundedCornerShape(4.dp)
                        )
                )
                Text(
                    text = status,
                    style = BodyMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = statusColor
                )
            }
            
            // View receipt button
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.clickable { onViewReceipt?.invoke() }
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_view),
                    contentDescription = null,
                    tint = Primary,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "Посмотреть",
                    style = BodyMedium,
                    color = Primary
                )
            }
            
            // Items section
            Column {
                Text(
                    text = "Описания",
                    style = TitleMedium.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = OnSurface,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                
                items.forEach { item ->
                    OrderItemRow(
                        itemName = item.name,
                        quantity = item.quantity,
                        unitPrice = item.unitPrice
                    )
                }
            }
            
            // Action buttons
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Secondary buttons
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SecondaryButton(
                        text = "Чек покупки",
                        onClick = { onViewReceipt?.invoke() },
                        modifier = Modifier.weight(1f)
                    )
                    
                    SecondaryButton(
                        text = "Помощь",
                        onClick = { onHelp?.invoke() },
                        modifier = Modifier.weight(1f)
                    )
                }
                
                // Cancel order button
                Surface(
                    onClick = { onCancelOrder?.invoke() },
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Transparent,
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 1.dp,
                                color = Error,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .padding(16.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Отменить заказ",
                            style = LabelLarge,
                            color = Error
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun OrderItemRow(
    itemName: String,
    quantity: Int,
    unitPrice: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = itemName,
            style = BodyMedium,
            color = OnSurface,
            modifier = Modifier.weight(1f)
        )
        
        Text(
            text = "$quantity x $unitPrice",
            style = BodyMedium,
            color = Neutral600
        )
    }
}

data class OrderItemDetail(
    val name: String,
    val quantity: Int,
    val unitPrice: String
)

// ===== ОБЩИЕ КОМПОНЕНТЫ =====
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TitleLarge,
                color = OnSurface
            )
        },
        navigationIcon = navigationIcon ?: {},
        actions = actions,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Surface,
            titleContentColor = OnSurface,
            navigationIconContentColor = OnSurface,
            actionIconContentColor = OnSurface
        ),
        modifier = modifier
    )
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier,
    message: String = "Loading..."
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = Primary,
                strokeWidth = 4.dp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = message,
                style = BodyMedium,
                color = OnSurface
            )
        }
    }
}

@Composable
fun EmptyState(
    title: String,
    message: String,
    modifier: Modifier = Modifier,
    action: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = TitleLarge,
            color = OnSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = message,
            style = BodyMedium,
            color = OnSurface.copy(alpha = 0.7f)
        )
        action?.let {
            Spacer(modifier = Modifier.height(24.dp))
            it()
        }
    }
}

// ===== ПРЕВЬЮ =====
@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryButton(
            text = "Основная кнопка",
            onClick = { }
        )

        SecondaryButton(
            text = "Вторичная кнопка",
            onClick = { }
        )

        TextButton(
            text = "Текстовая кнопка",
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtonsStates() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Состояния основных кнопок", style = TitleMedium)
        
        PrimaryButton(
            text = "Обычное состояние",
            onClick = { }
        )
        
        PrimaryButton(
            text = "Состояние загрузки",
            onClick = { },
            loading = true
        )
        
        PrimaryButton(
            text = "Отключенное состояние",
            onClick = { },
            enabled = false
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        Text("Состояния вторичных кнопок", style = TitleMedium)
        
        SecondaryButton(
            text = "Обычное состояние",
            onClick = { }
        )
        
        SecondaryButton(
            text = "Отключенное состояние",
            onClick = { },
            enabled = false
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        Text("Состояния текстовых кнопок", style = TitleMedium)
        
        TextButton(
            text = "Обычное состояние",
            onClick = { }
        )
        
        TextButton(
            text = "Отключенное состояние",
            onClick = { },
            enabled = false
        )
        
        TextButton(
            text = "Пользовательский цвет",
            onClick = { },
            textColor = Error
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCards() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryCard {
            Text(
                text = "Основная карточка",
                style = TitleLarge
            )
            Text(
                text = "Это основная карточка с тенью",
                style = BodyMedium
            )
        }

        OutlinedCard {
            Text(
                text = "Контурная карточка",
                style = TitleMedium
            )
            Text(
                text = "Это контурная карточка",
                style = BodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardsVariations() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Card Variations", style = TitleLarge)
        
        // Simple card
        PrimaryCard {
            Text(
                text = "Simple Card",
                style = TitleMedium
            )
            Text(
                text = "Just text content",
                style = BodyMedium
            )
        }
        
        // Card with buttons
        PrimaryCard {
            Text(
                text = "Card with Actions",
                style = TitleMedium
            )
            Text(
                text = "This card includes action buttons",
                style = BodyMedium
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextButton(
                    text = "Cancel",
                    onClick = { },
                    textColor = Neutral600
                )
                TextButton(
                    text = "Save",
                    onClick = { }
                )
            }
        }
        
        // Outlined card with status
        OutlinedCard {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Task Card",
                        style = TitleMedium
                    )
                    Text(
                        text = "Complete the project",
                        style = BodyMedium
                    )
                }
                StatusChip(
                    text = "In Progress",
                    status = StatusType.Info
                )
            }
        }
        
        // Card with progress
        PrimaryCard {
            Text(
                text = "Progress Card",
                style = TitleMedium
            )
            Text(
                text = "Project completion",
                style = BodyMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProgressIndicator(
                progress = 0.6f
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "60% completed",
                style = BodySmall,
                color = Neutral600
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInputs() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PrimaryTextField(
            value = "",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email"
        )

        PrimaryTextField(
            value = "",
            onValueChange = { },
            label = "Password",
            placeholder = "Enter your password",
            isError = true,
            errorMessage = "Password is required"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInputsStates() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Input Field States", style = TitleLarge)
        
        // Normal state
        PrimaryTextField(
            value = "john.doe@example.com",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email"
        )
        
        // Empty state
        PrimaryTextField(
            value = "",
            onValueChange = { },
            label = "Username",
            placeholder = "Enter your username"
        )
        
        // Error state
        PrimaryTextField(
            value = "invalid-email",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email",
            isError = true,
            errorMessage = "Please enter a valid email address"
        )
        
        // Disabled state
        PrimaryTextField(
            value = "readonly@example.com",
            onValueChange = { },
            label = "Email",
            placeholder = "Enter your email",
            enabled = false
        )
        
        // Without label
        PrimaryTextField(
            value = "",
            onValueChange = { },
            placeholder = "Search..."
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatus() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatusChip(
                text = "Success",
                status = StatusType.Success
            )

            StatusChip(
                text = "Error",
                status = StatusType.Error
            )

            StatusChip(
                text = "Warning",
                status = StatusType.Warning
            )
        }

        ProgressIndicator(
            progress = 0.7f
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStatusVariations() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Status Chips", style = TitleLarge)
        
        // All status types
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StatusChip(
                text = "Success",
                status = StatusType.Success
            )
            StatusChip(
                text = "Error",
                status = StatusType.Error
            )
            StatusChip(
                text = "Warning",
                status = StatusType.Warning
            )
        }
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            StatusChip(
                text = "Info",
                status = StatusType.Info
            )
            StatusChip(
                text = "Neutral",
                status = StatusType.Neutral
            )
        }
        
        Text("Progress Indicators", style = TitleLarge)
        
        // Different progress values
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("25% Complete", style = BodyMedium)
            ProgressIndicator(
                progress = 0.25f,
                color = Error
            )
            
            Text("50% Complete", style = BodyMedium)
            ProgressIndicator(
                progress = 0.5f,
                color = Warning
            )
            
            Text("75% Complete", style = BodyMedium)
            ProgressIndicator(
                progress = 0.75f,
                color = Info
            )
            
            Text("100% Complete", style = BodyMedium)
            ProgressIndicator(
                progress = 1.0f,
                color = Success
            )
        }
        
        Text("Loading States", style = TitleLarge)
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Primary,
                    strokeWidth = 3.dp
                )
            }
            
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    color = Success,
                    strokeWidth = 2.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCommonComponents() {
    Column {
        AppBar(
            title = "Common Components"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text("AppBar Examples", style = TitleLarge)
            
            // Simple AppBar
            AppBar(
                title = "Simple AppBar"
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text("Loading Screen", style = TitleLarge)
            LoadingScreen(
                message = "Loading your data..."
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text("Empty State", style = TitleLarge)
            EmptyState(
                title = "No Data Found",
                message = "There are no items to display at the moment. Try refreshing or check back later.",
                action = {
                    PrimaryButton(
                        text = "Refresh",
                        onClick = { }
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCompleteScreen() {
    Column {
        AppBar(
            title = "UIkit Preview"
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimaryButton(
                text = "Get Started",
                onClick = { }
            )

            PrimaryCard {
                Text(
                    text = "Welcome to UIkit",
                    style = TitleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "This is a comprehensive UI component library with beautiful, modern components.",
                    style = BodyMedium
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                StatusChip(
                    text = "Ready",
                    status = StatusType.Success
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTypography() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Typography System", style = TitleLarge)
        
        // Display styles
        Text("Display Large", style = DisplayLarge)
        Text("Display Large - This is the largest text style for prominent headlines", style = DisplayLarge)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Headline styles
        Text("Headline Large", style = HeadlineLarge)
        Text("Headline Large - Used for section headers and important titles", style = HeadlineLarge)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Title styles
        Text("Title Large", style = TitleLarge)
        Text("Title Large - Perfect for card titles and important headings", style = TitleLarge)
        
        Text("Title Medium", style = TitleMedium)
        Text("Title Medium - Great for subsection headers", style = TitleMedium)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Body styles
        Text("Body Large", style = BodyLarge)
        Text("Body Large - Main content text with good readability", style = BodyLarge)
        
        Text("Body Medium", style = BodyMedium)
        Text("Body Medium - Standard body text for most content", style = BodyMedium)
        
        Text("Body Small", style = BodySmall)
        Text("Body Small - Secondary information and captions", style = BodySmall)
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Label styles
        Text("Label Large", style = LabelLarge)
        Text("Label Large - Button text and important labels", style = LabelLarge)
        
        Text("Label Medium", style = LabelMedium)
        Text("Label Medium - Form labels and secondary buttons", style = LabelMedium)
        
        Text("Label Small", style = LabelSmall)
        Text("Label Small - Small labels and tags", style = LabelSmall)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColors() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Color Palette", style = TitleLarge)
        
        // Primary colors
        Text("Primary Colors", style = TitleMedium)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ColorSwatch("Primary", Primary)
            ColorSwatch("Primary Variant", PrimaryVariant)
            ColorSwatch("Secondary", Secondary)
        }
        
        // Status colors
        Text("Status Colors", style = TitleMedium)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ColorSwatch("Success", Success)
            ColorSwatch("Error", Error)
            ColorSwatch("Warning", Warning)
            ColorSwatch("Info", Info)
        }
        
        // Surface colors
        Text("Surface Colors", style = TitleMedium)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ColorSwatch("Surface", Surface)
            ColorSwatch("Background", Background)
            ColorSwatch("Border", Border)
        }
        
        // Neutral colors
        Text("Neutral Colors", style = TitleMedium)
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ColorSwatch("50", Neutral50)
                ColorSwatch("100", Neutral100)
                ColorSwatch("200", Neutral200)
                ColorSwatch("300", Neutral300)
                ColorSwatch("400", Neutral400)
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ColorSwatch("500", Neutral500)
                ColorSwatch("600", Neutral600)
                ColorSwatch("700", Neutral700)
                ColorSwatch("800", Neutral800)
                ColorSwatch("900", Neutral900)
            }
        }
    }
}

@Composable
fun ColorSwatch(
    name: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = color,
                    shape = RoundedCornerShape(8.dp)
                )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = name,
            style = LabelSmall,
            color = if (color == Neutral50 || color == Neutral100 || color == Neutral200) OnSurface else Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMedicalComponents() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Medical Components", style = TitleLarge)
        
        // Result table cells
        ResultTableCell(
            parameterName = "Гематокрит",
            value = "36.5",
            range = "11.1 – 14.1",
            valueColor = Success
        )
        
        ResultTableCell(
            parameterName = "Гемоглобин",
            value = "12.3",
            range = "11.1 – 14.1",
            valueColor = Error
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderComponents() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Order Components", style = TitleLarge)
        
        // Order cells
        OrderCell(
            itemName = "Рубашка Воскресенье для машинного вязания",
            price = "300 ₽",
            isSelected = true
        )
        
        OrderCell(
            itemName = "Шорты Вторник для машинного вязания",
            price = "690 ₽",
            isSelected = false
        )
        
        // Order card opened
        OrderCardOpened(
            orderNumber = "123456",
            totalPrice = "2580 Р",
            date = "26 апреля, 14:00",
            status = "Оплачен",
            statusColor = Success,
            items = listOf(
                OrderItemDetail(
                    name = "Рубашка Воскресенье для машинного вязания",
                    quantity = 1,
                    unitPrice = "300 Р"
                ),
                OrderItemDetail(
                    name = "Шорты Вторник для машинного вязания",
                    quantity = 1,
                    unitPrice = "690 Р"
                )
            ),
            onViewReceipt = { },
            onHelp = { },
            onCancelOrder = { }
        )
    }
}
