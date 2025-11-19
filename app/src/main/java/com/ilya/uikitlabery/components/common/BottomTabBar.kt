package com.ilya.uikitlabery.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

/**
 * Элемент таббара
 */
data class TabItem(
    val title: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector? = null
)

/**
 * Нижний таббар (Bottom Navigation)
 */
@Composable
fun BottomTabBar(
    items: List<TabItem>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Surface,
        contentColor = OnSurface
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = if (index == selectedIndex && item.selectedIcon != null) {
                            item.selectedIcon
                        } else {
                            item.icon
                        },
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        style = LabelSmall
                    )
                },
                selected = index == selectedIndex,
                onClick = { onItemSelected(index) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Primary,
                    selectedTextColor = Primary,
                    indicatorColor = Primary.copy(alpha = 0.1f),
                    unselectedIconColor = Neutral600,
                    unselectedTextColor = Neutral600
                )
            )
        }
    }
}

/**
 * Предустановленные табы для примера
 */
val defaultTabItems = listOf(
    TabItem(
        title = "Главная",
        icon = Icons.Default.Home,
        selectedIcon = Icons.Default.Home
    ),
    TabItem(
        title = "Каталог",
        icon = Icons.Default.GridView,
        selectedIcon = Icons.Default.GridView
    ),
    TabItem(
        title = "Проекты",
        icon = Icons.Default.Folder,
        selectedIcon = Icons.Default.Folder
    ),
    TabItem(
        title = "Профиль",
        icon = Icons.Default.Person,
        selectedIcon = Icons.Default.Person
    )
)

