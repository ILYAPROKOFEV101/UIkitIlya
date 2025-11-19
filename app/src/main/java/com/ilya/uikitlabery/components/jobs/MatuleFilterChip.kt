package com.ilya.compose.components.jobs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.ilya.uikitlabery.LabelLarge
import com.ilya.uikitlabery.Neutral100
import com.ilya.uikitlabery.Neutral200
import com.ilya.uikitlabery.Neutral900
import com.ilya.uikitlabery.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MatuleFilterChip(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector? = null,
    onClick: () -> Unit,
) {
    val background = if (selected) Primary.copy(alpha = 0.12f) else Neutral100
    val contentColor = if (selected) Primary else Neutral900
    val border = if (selected) BorderStroke(0.dp, Color.Transparent) else BorderStroke(1.dp, Neutral200)

    Surface(
        modifier = modifier,
        color = background,
        contentColor = contentColor,
        shape = RoundedCornerShape(18.dp),
        border = border,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier.size(16.dp)
                )
            }

            Text(
                text = text,
                style = LabelLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = contentColor
            )
        }
    }
}

@Preview
@Composable
private fun MatuleFilterChipPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        MatuleFilterChip(text = "Все вакансии", selected = true, onClick = {})
        MatuleFilterChip(text = "Дизайн", selected = false, onClick = {})
        MatuleFilterChip(text = "Маркетинг", selected = false, onClick = {})
    }
}
