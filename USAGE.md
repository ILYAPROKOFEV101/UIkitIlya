# Как использовать библиотеку UIkitIlya

## Установка

### 1. Добавьте JitPack в репозитории

В файле `settings.gradle.kts`:

```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // ← Добавьте эту строку
    }
}
```

### 2. Добавьте зависимость

В файле `build.gradle.kts` вашего модуля (обычно `app/build.gradle.kts`):

```kotlin
dependencies {
    // Ваша библиотека
    implementation("com.github.ILYAPROKOFEV101:UIkitIlya:1.0.0")
    
    // Остальные зависимости...
}
```

### 3. Синхронизируйте проект

В Android Studio нажмите "Sync Now" или выполните:
```bash
./gradlew build
```

## Пример использования

```kotlin
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ilya.uikitlabery.*

@Composable
fun MyScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Использование кнопок
        PrimaryButton(
            text = "Нажми меня",
            onClick = { /* ваше действие */ }
        )
        
        SecondaryButton(
            text = "Вторичная кнопка",
            onClick = { /* ваше действие */ }
        )
        
        // Использование карточек
        PrimaryCard {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Заголовок", style = TitleLarge)
                Text("Описание", style = BodyMedium)
            }
        }
        
        // Использование полей ввода
        PrimaryTextField(
            value = text,
            onValueChange = { text = it },
            label = "Введите текст",
            placeholder = "Начните вводить..."
        )
        
        // Использование статусов
        StatusChip(
            text = "Успешно",
            status = StatusType.Success
        )
        
        // Использование цветов
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Primary)
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
- `PrimaryCard` - основная карточка с тенью
- `OutlinedCard` - карточка с обводкой

### Поля ввода
- `PrimaryTextField` - текстовое поле с поддержкой ошибок

### Статусы
- `StatusChip` - чип со статусом (Success, Warning, Error, Info, Neutral)
- `ProgressIndicator` - индикатор прогресса

### Цвета
- `Primary`, `PrimaryVariant`, `Secondary`
- `Success`, `Warning`, `Error`, `Info`
- `Surface`, `OnSurface`, `Background`
- `Neutral50` - `Neutral900`
- `Border`

### Типографика
- `DisplayLarge`, `DisplayMedium`, `DisplaySmall`
- `HeadlineLarge`, `HeadlineMedium`, `HeadlineSmall`
- `TitleLarge`, `TitleMedium`, `TitleSmall`
- `BodyLarge`, `BodyMedium`, `BodySmall`
- `LabelLarge`, `LabelMedium`, `LabelSmall`

## Важные замечания

⚠️ **Если репозиторий приватный:**
JitPack не может собрать приватные репозитории. Сделайте репозиторий публичным:
1. Перейдите в Settings репозитория на GitHub
2. Прокрутите вниз до "Danger Zone"
3. Нажмите "Change visibility" → "Make public"

✅ **После публикации:**
- Подождите 2-5 минут
- Проверьте: https://jitpack.io/#ILYAPROKOFEV101/UIkitIlya
- Если версия не появилась, нажмите "Get it" на странице JitPack

## Обновление версии

При выходе новой версии просто измените номер версии:
```kotlin
implementation("com.github.ILYAPROKOFEV101:UIkitIlya:1.0.1")
```

## Поддержка

Если возникли проблемы:
- Проверьте, что репозиторий публичный
- Убедитесь, что релиз создан на GitHub
- Проверьте страницу JitPack: https://jitpack.io/#ILYAPROKOFEV101/UIkitIlya

