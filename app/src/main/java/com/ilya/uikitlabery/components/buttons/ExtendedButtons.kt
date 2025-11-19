package com.ilya.uikitlabery.components.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

/**
 * Большая кнопка
 */
@Composable
fun BigButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        enabled = enabled,
        colors = when (variant) {
            ButtonVariant.Primary -> ButtonDefaults.buttonColors(
                containerColor = Primary,
                contentColor = Color.White,
                disabledContainerColor = Neutral300,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Secondary -> ButtonDefaults.buttonColors(
                containerColor = Secondary,
                contentColor = Color.White,
                disabledContainerColor = Neutral300,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Outlined -> ButtonDefaults.outlinedButtonColors(
                contentColor = Primary,
                disabledContentColor = Neutral600
            )
        },
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
    ) {
        Text(
            text = text,
            style = TitleMedium.copy(fontWeight = FontWeight.Bold)
        )
    }
}

/**
 * Средняя кнопка
 */
@Composable
fun MediumButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(48.dp),
        enabled = enabled,
        colors = when (variant) {
            ButtonVariant.Primary -> ButtonDefaults.buttonColors(
                containerColor = Primary,
                contentColor = Color.White,
                disabledContainerColor = Neutral300,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Secondary -> ButtonDefaults.outlinedButtonColors(
                contentColor = Primary,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Outlined -> ButtonDefaults.outlinedButtonColors(
                contentColor = Neutral700,
                disabledContentColor = Neutral600
            )
        },
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            style = BodyMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

/**
 * Маленькая кнопка
 */
@Composable
fun SmallButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    variant: ButtonVariant = ButtonVariant.Primary
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(40.dp),
        enabled = enabled,
        colors = when (variant) {
            ButtonVariant.Primary -> ButtonDefaults.buttonColors(
                containerColor = Primary,
                contentColor = Color.White,
                disabledContainerColor = Neutral300,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Secondary -> ButtonDefaults.outlinedButtonColors(
                contentColor = Primary,
                disabledContentColor = Neutral600
            )
            ButtonVariant.Outlined -> ButtonDefaults.outlinedButtonColors(
                contentColor = Neutral700,
                disabledContentColor = Neutral600
            )
        },
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = text,
            style = BodySmall.copy(fontWeight = FontWeight.Medium)
        )
    }
}

/**
 * Кнопка-чип
 */
@Composable
fun ChipButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(
                text = text,
                style = LabelMedium
            )
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Primary,
            selectedLabelColor = Color.White,
            containerColor = Surface,
            labelColor = Neutral700,
            disabledContainerColor = Neutral200,
            disabledLabelColor = Neutral500
        ),
        shape = RoundedCornerShape(20.dp)
    )
}

/**
 * Кнопка корзины
 */
@Composable
fun CartButton(
    text: String,
    price: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: ImageVector = Icons.Default.ShoppingCart
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary,
            contentColor = Color.White,
            disabledContainerColor = Neutral300,
            disabledContentColor = Neutral600
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Text(
                    text = text,
                    style = BodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
            Text(
                text = price,
                style = BodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

/**
 * Кнопка социальной сети
 */
@Composable
fun SocialLoginButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = OnSurface
        ),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(
                text = text,
                style = BodyMedium
            )
        }
    }
}

/**
 * Варианты кнопок
 */
enum class ButtonVariant {
    Primary,
    Secondary,
    Outlined
}

