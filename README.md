# UIkitlabery

UI компонентная библиотека для Android Compose с готовыми компонентами: кнопки, карточки, поля ввода, статусы и многое другое.

## Установка

### Через JitPack (Рекомендуется)

Добавьте в `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Добавьте зависимость в `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.ILYAPROKOFEV101:UIkitIlya:1.0.0")
}
```

### Через Maven Local

Если библиотека опубликована локально:

```kotlin
repositories {
    mavenLocal()
    // ...
}

dependencies {
    implementation("com.ilya:uikitlabery:1.0.0")
}
```

## Быстрый старт

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ilya.uikitlabery.*

@Composable
fun MyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Кнопки
        PrimaryButton(
            text = "Нажми меня",
            onClick = { /* действие */ }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Карточки
        PrimaryCard {
            Text("Содержимое карточки")
        }
        
        // Поля ввода
        PrimaryTextField(
            value = text,
            onValueChange = { text = it },
            label = "Введите текст"
        )
    }
}
```

## Доступные компоненты

### Кнопки
- `PrimaryButton` - основная кнопка
- `SecondaryButton` - вторичная кнопка
- `TextButton` - текстовая кнопка

### Карточки
- `PrimaryCard` - основная карточка
- `OutlinedCard` - карточка с обводкой

### Поля ввода
- `PrimaryTextField` - текстовое поле

### Статусы
- `StatusChip` - чип со статусом
- `ProgressIndicator` - индикатор прогресса

### Цвета и типографика
- Готовые цвета: `Primary`, `Secondary`, `Error`, `Success`, `Warning`, `Info`
- Типографика: `TitleLarge`, `BodyMedium`, `LabelSmall` и другие

## Документация

Подробная документация по публикации и использованию: [PUBLISH.md](PUBLISH.md)

## Лицензия

Apache License 2.0

