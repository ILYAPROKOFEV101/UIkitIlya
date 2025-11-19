package com.ilya.compose.components.jobs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.ilya.uikitlabery.BodyMedium
import com.ilya.uikitlabery.BodySmall
import com.ilya.uikitlabery.LabelLarge
import com.ilya.uikitlabery.Neutral100
import com.ilya.uikitlabery.Neutral500
import com.ilya.uikitlabery.Neutral900
import com.ilya.uikitlabery.OnSurface
import com.ilya.uikitlabery.Primary
import com.ilya.uikitlabery.TitleMedium

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MatuleJobCard(
    title: String,
    company: String,
    location: String,
    salary: String?,
    tags: List<String>,
    experience: String,
    publishedAt: String,
    bookmarked: Boolean,
    modifier: Modifier = Modifier,
    onBookmarkClick: (() -> Unit)? = null,
    onApplyClick: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    val colors = CardDefaults.cardColors(containerColor = Color.White)
    val shape = RoundedCornerShape(28.dp)

    val cardContent: @Composable () -> Unit = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(Color.White, Neutral100)
                    ),
                    shape = RoundedCornerShape(28.dp)
                )
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = TitleMedium.copy(fontSize = 20.sp),
                        color = OnSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = company,
                        style = BodyMedium,
                        color = Neutral500
                    )
                }

                if (onBookmarkClick != null) {
                    IconButton(
                        onClick = onBookmarkClick,
                        modifier = Modifier.size(40.dp)
                    ) {
                        Icon(
                            imageVector = if (bookmarked) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder,
                            contentDescription = null,
                            tint = if (bookmarked) Primary else Neutral500
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (!salary.isNullOrBlank()) {
                Text(
                    text = salary,
                    style = LabelLarge.copy(color = Primary),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (experience.isNotBlank()) {
                    MatuleJobTag(text = experience)
                }
                tags.forEach { tag ->
                    if (tag.isNotBlank()) {
                        MatuleJobTag(text = tag)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (location.isNotBlank()) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                            tint = Primary,
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.size(6.dp))
                        Text(
                            text = location,
                            style = BodyMedium,
                            color = OnSurface
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Schedule,
                        contentDescription = null,
                        tint = Neutral500,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = publishedAt,
                        style = BodySmall,
                        color = Neutral500
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (onApplyClick != null) {
                TextButton(
                    onClick = onApplyClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Откликнуться", style = LabelLarge.copy(color = Primary))
                }
            }
        }
    }

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) { cardContent() }
    } else {
        Card(
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) { cardContent() }
    }
}

@Composable
private fun MatuleJobTag(text: String) {
    Surface(
        color = Neutral100,
        shape = RoundedCornerShape(14.dp)
    ) {
        Text(
            text = text,
            style = BodySmall.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            color = Neutral900
        )
    }
}

@Preview
@Composable
private fun MatuleJobCardPreview() {
    MatuleJobCard(
        title = "Senior Product Designer",
        company = "Matule Studio",
        location = "Москва · гибрид",
        salary = "от 180 000 ₽",
        tags = listOf("Полная занятость", "Удаленно", "Figma"),
        experience = "Middle",
        publishedAt = "3 дня назад",
        bookmarked = false,
        onBookmarkClick = {},
        onApplyClick = {},
        onClick = {}
    )
}
