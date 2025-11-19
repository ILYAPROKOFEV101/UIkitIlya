# Новые компоненты библиотеки

## Расширенные инпуты

### AdvancedInput
Поле ввода с поддержкой иконок и различных состояний.

```kotlin
import com.ilya.uikitlabery.components.inputs.AdvancedInput
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person

AdvancedInput(
    value = text,
    onValueChange = { text = it },
    label = "Имя",
    placeholder = "Введите имя",
    leadingIcon = Icons.Default.Person,
    showClearButton = true,
    isError = false,
    errorMessage = "Введите ваше имя"
)
```

### SmallNumberInput
Маленькое числовое поле ввода.

```kotlin
import com.ilya.uikitlabery.components.inputs.SmallNumberInput

SmallNumberInput(
    value = quantity,
    onValueChange = { quantity = it },
    placeholder = "1"
)
```

## Селекты

### SelectField
Выпадающий список с поддержкой эмодзи.

```kotlin
import com.ilya.uikitlabery.components.inputs.SelectField
import com.ilya.uikitlabery.components.inputs.SelectItem

val items = listOf(
    SelectItem("1", "Мужской"),
    SelectItem("2", "Женский", emoji = "👩"),
    SelectItem("3", "Гарвард Троцкий", emoji = "👱‍♂️")
)

SelectField(
    selectedItem = selectedItem,
    onItemSelected = { selectedItem = it },
    items = items,
    label = "Пол",
    placeholder = "Выберите...",
    showClearButton = true
)
```

### DatePickerField
Поле выбора даты.

```kotlin
import com.ilya.uikitlabery.components.inputs.DatePickerField

DatePickerField(
    selectedDate = date,
    onDateSelected = { date = it },
    label = "Дата",
    placeholder = "Выберите дату"
)
```

## Расширенные кнопки

### BigButton
Большая кнопка (56dp высота).

```kotlin
import com.ilya.uikitlabery.components.buttons.BigButton
import com.ilya.uikitlabery.components.buttons.ButtonVariant

BigButton(
    text = "Подтвердить",
    onClick = { /* действие */ },
    variant = ButtonVariant.Primary // или Secondary, Outlined
)
```

### MediumButton
Средняя кнопка (48dp высота).

```kotlin
import com.ilya.uikitlabery.components.buttons.MediumButton

MediumButton(
    text = "Добавить заказчика",
    onClick = { /* действие */ },
    variant = ButtonVariant.Primary
)
```

### SmallButton
Маленькая кнопка (40dp высота).

```kotlin
import com.ilya.uikitlabery.components.buttons.SmallButton

SmallButton(
    text = "Добавить",
    onClick = { /* действие */ }
)
```

### ChipButton
Кнопка-чип (для фильтров).

```kotlin
import com.ilya.uikitlabery.components.buttons.ChipButton

ChipButton(
    text = "Популярные",
    onClick = { /* действие */ },
    selected = isSelected
)
```

### CartButton
Кнопка корзины с ценой.

```kotlin
import com.ilya.uikitlabery.components.buttons.CartButton

CartButton(
    text = "В корзину",
    price = "500 Р",
    onClick = { /* действие */ }
)
```

### SocialLoginButton
Кнопка входа через социальную сеть.

```kotlin
import com.ilya.uikitlabery.components.buttons.SocialLoginButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.* // для иконок VK, Yandex и т.д.

SocialLoginButton(
    text = "Войти с VK",
    onClick = { /* действие */ },
    icon = Icons.Default.AccountCircle // замените на нужную иконку
)
```

## Поиск

### SearchBar
Компонент поиска с иконкой и кнопкой отмены.

```kotlin
import com.ilya.uikitlabery.components.common.SearchBar

SearchBar(
    value = searchQuery,
    onValueChange = { searchQuery = it },
    placeholder = "Искать описание",
    showCancelButton = true,
    onCancelClick = { searchQuery = "" },
    onSearchClick = { /* выполнить поиск */ }
)
```

## Таббар

### BottomTabBar
Нижняя навигация (Bottom Navigation).

```kotlin
import com.ilya.uikitlabery.components.common.BottomTabBar
import com.ilya.uikitlabery.components.common.TabItem
import com.ilya.uikitlabery.components.common.defaultTabItems
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

var selectedTab by remember { mutableStateOf(0) }

BottomTabBar(
    items = defaultTabItems, // или создайте свой список
    selectedIndex = selectedTab,
    onItemSelected = { selectedTab = it }
)

// Или создайте свой список:
val customTabs = listOf(
    TabItem("Главная", Icons.Default.Home),
    TabItem("Каталог", Icons.Default.GridView),
    TabItem("Проекты", Icons.Default.Folder),
    TabItem("Профиль", Icons.Default.Person)
)
```

## Все новые компоненты

### Инпуты
- `AdvancedInput` - расширенное поле ввода
- `SmallNumberInput` - числовое поле
- `SelectField` - выпадающий список
- `DatePickerField` - выбор даты

### Кнопки
- `BigButton` - большая кнопка
- `MediumButton` - средняя кнопка
- `SmallButton` - маленькая кнопка
- `ChipButton` - кнопка-чип
- `CartButton` - кнопка корзины
- `SocialLoginButton` - кнопка социальной сети

### Общие компоненты
- `SearchBar` - поиск
- `BottomTabBar` - нижний таббар

## Импорты

Для использования всех компонентов:

```kotlin
import com.ilya.uikitlabery.components.inputs.*
import com.ilya.uikitlabery.components.buttons.*
import com.ilya.uikitlabery.components.common.*
```

