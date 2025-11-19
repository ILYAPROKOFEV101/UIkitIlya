package com.ilya.compose.components.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.BodyLarge
import com.ilya.uikitlabery.BodyMedium
import com.ilya.uikitlabery.BodySmall
import com.ilya.uikitlabery.LabelLarge
import com.ilya.uikitlabery.Neutral100
import com.ilya.uikitlabery.Neutral200
import com.ilya.uikitlabery.Neutral500
import com.ilya.uikitlabery.Neutral900
import com.ilya.uikitlabery.OnSurface
import com.ilya.uikitlabery.Primary
import com.ilya.uikitlabery.TitleMedium
/**
 * Матюле поле поиска из макета.
 */
@Composable
fun MatuleSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    onFilterClick: (() -> Unit)? = null,
    onClearClick: (() -> Unit)? = null,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        tonalElevation = 4.dp,
        shadowElevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 1.dp, color = Neutral200, shape = RoundedCornerShape(24.dp))
                .clip(RoundedCornerShape(24.dp))
                .padding(horizontal = 20.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                tint = Primary
            )

            Box(modifier = Modifier.weight(1f)) {
                if (value.isBlank()) {
                    Text(
                        text = placeholder,
                        style = BodyLarge,
                        color = Neutral500,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.alpha(0.9f)
                    )
                }

                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    textStyle = BodyLarge.copy(color = OnSurface),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }

            if (value.isNotEmpty() && onClearClick != null) {
                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Neutral100)
                        .clickable(onClick = onClearClick),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = null,
                        tint = Neutral500,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            if (onFilterClick != null) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .background(Primary.copy(alpha = 0.12f))
                        .clickable(onClick = onFilterClick)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Outlined.FilterList,
                        contentDescription = null,
                        tint = Primary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MatuleSearchBarPreview() {
    var value by remember { mutableStateOf("") }
    Surface(color = Color(0xFFF5F5F5)) {
        Column(modifier = Modifier.padding(16.dp)) {
            MatuleSearchBar(
                value = value,
                onValueChange = { value = it },
                placeholder = "Поиск вакансий",
                onFilterClick = {},
                onClearClick = { value = "" }
            )
            Spacer(modifier = Modifier.height(16.dp))
            MatuleSearchBar(
                value = "Product Designer",
                onValueChange = { value = it },
                placeholder = "Поиск вакансий",
                onFilterClick = {},
                onClearClick = { value = "" }
            )
        }
    }
}
