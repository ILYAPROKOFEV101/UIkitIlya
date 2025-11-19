# Инструкция по публикации и использованию библиотеки

## Публикация библиотеки в Maven Local

1. **Опубликовать библиотеку в Maven Local:**
   ```bash
   ./gradlew publishReleasePublicationToMavenLocal
   ```

   После выполнения команды библиотека будет доступна в `~/.m2/repository/com/ilya/uikitlabery/1.0.0/`

   **Примечание:** Предупреждения о перезаписи файлов при создании sources JAR - это нормальное поведение Gradle.

## Использование библиотеки в приложении

1. **Добавьте Maven Local в репозитории** (в `settings.gradle.kts`):
   ```kotlin
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           google()
           mavenCentral()
           mavenLocal()  // Добавьте эту строку
       }
   }
   ```

   Или в `build.gradle.kts` модуля приложения:
   ```kotlin
   repositories {
       mavenLocal()
       google()
       mavenCentral()
   }
   ```

2. **Добавьте зависимость** в `build.gradle.kts` вашего приложения:
   ```kotlin
   dependencies {
       implementation("com.ilya:uikitlabery:1.0.0")
   }
   ```

3. **Синхронизируйте проект** в Android Studio

## Пример использования

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
        // Использование кнопок
        PrimaryButton(
            text = "Нажми меня",
            onClick = { /* действие */ }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Использование карточек
        PrimaryCard {
            Text("Содержимое карточки")
        }
        
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

## Изменение версии библиотеки

Для изменения версии библиотеки отредактируйте файл `app/build.gradle.kts`:
```kotlin
version = "1.0.1" // измените на нужную версию
```

После изменения версии выполните команду публикации снова:
```bash
./gradlew publishReleasePublicationToMavenLocal
```

## Проверка публикации

Проверить, что библиотека опубликована, можно командой:
```bash
ls -la ~/.m2/repository/com/ilya/uikitlabery/1.0.0/
```

Должны быть файлы:
- `uikitlabery-1.0.0.aar` - сама библиотека
- `uikitlabery-1.0.0.pom` - метаданные
- `uikitlabery-1.0.0-sources.jar` - исходный код

---

# Публикация библиотеки в интернет

## Вариант 1: JitPack (Рекомендуется - самый простой способ)

JitPack автоматически собирает библиотеку из GitHub репозитория. Не требует дополнительной настройки!

### Шаги:

1. **Создайте репозиторий на GitHub:**
   - Зайдите на https://github.com
   - Создайте новый репозиторий (например, `UIkitlabery`)
   - **Важно:** Имя репозитория должно совпадать с именем проекта

2. **Загрузите код на GitHub:**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   git branch -M main
   git remote add origin https://github.com/ilyaprokofev/UIkitlabery.git
   git push -u origin main
   ```

3. **Создайте релиз (Release) на GitHub:**
   - Перейдите в репозиторий на GitHub
   - Нажмите "Releases" → "Create a new release"
   - Введите версию (например, `v1.0.0`)
   - Нажмите "Publish release"

4. **Используйте библиотеку в других проектах:**

   Добавьте в `settings.gradle.kts`:
   ```kotlin
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           google()
           mavenCentral()
           maven { url = uri("https://jitpack.io") }  // Добавьте JitPack
       }
   }
   ```

   Добавьте зависимость в `build.gradle.kts`:
   ```kotlin
   dependencies {
       implementation("com.github.ilyaprokofev:UIkitlabery:1.0.0")
       // или для последнего коммита:
       // implementation("com.github.ilyaprokofev:UIkitlabery:main-SNAPSHOT")
   }
   ```

   **Формат зависимости:**
   - `com.github.USERNAME:REPOSITORY:VERSION` - для релизов
   - `com.github.USERNAME:REPOSITORY:COMMIT-SHA` - для конкретного коммита
   - `com.github.USERNAME:REPOSITORY:BRANCH-SNAPSHOT` - для ветки

### Проверка на JitPack:

После создания релиза, проверьте на https://jitpack.io/#ilyaprokofev/UIkitlabery

---

## Вариант 2: GitHub Packages

GitHub Packages позволяет публиковать библиотеку прямо в GitHub.

### Шаги:

1. **Создайте Personal Access Token:**
   - GitHub → Settings → Developer settings → Personal access tokens → Tokens (classic)
   - Создайте токен с правами `write:packages` и `read:packages`

2. **Добавьте токен в `gradle.properties`** (в корне проекта):
   ```properties
   gpr.user=ilyaprokofev
   gpr.token=YOUR_GITHUB_TOKEN
   ```

3. **Опубликуйте библиотеку:**
   ```bash
   ./gradlew publishReleasePublicationToGitHubPackages
   ```

4. **Используйте библиотеку в других проектах:**

   Добавьте в `settings.gradle.kts`:
   ```kotlin
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
       repositories {
           google()
           mavenCentral()
           maven {
               name = "GitHubPackages"
               url = uri("https://maven.pkg.github.com/ilyaprokofev/UIkitlabery")
               credentials {
                   username = "ilyaprokofev"
                   password = "YOUR_GITHUB_TOKEN"
               }
           }
       }
   }
   ```

   Добавьте зависимость:
   ```kotlin
   dependencies {
       implementation("com.github.ilyaprokofev:uikitlabery:1.0.0")
   }
   ```

---

## Вариант 3: Maven Central (Sonatype)

Для публикации в Maven Central требуется регистрация и более сложная настройка. Подробнее: https://central.sonatype.org/publish/publish-guide/

---

## Рекомендация

**Используйте JitPack** - это самый простой способ:
- ✅ Не требует регистрации
- ✅ Автоматическая сборка
- ✅ Работает сразу после создания релиза на GitHub
- ✅ Бесплатно

Просто создайте репозиторий на GitHub, загрузите код, создайте релиз - и библиотека будет доступна через JitPack!

