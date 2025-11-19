plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    `maven-publish`
}

android {
    namespace = "com.ilya.uikitlabery"
    compileSdk = 36

    defaultConfig {
        minSdk = 25

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

// Переменные для версии
val libraryVersion = "1.0.0"
val libraryGroupId = "com.github.ILYAPROKOFEV101" // Для JitPack используйте ваш GitHub username

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                
                groupId = libraryGroupId
                artifactId = "UIkitIlya"  // Имя должно совпадать с именем репозитория для JitPack
                version = libraryVersion
                
                pom {
                    name.set("UIkitlabery")
                    description.set("UI component library for Android Compose")
                    url.set("https://github.com/ILYAPROKOFEV101/UIkitIlya")
                    
                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    
                    developers {
                        developer {
                            id.set("ILYAPROKOFEV101")
                            name.set("Ilya Prokofev")
                        }
                    }
                    
                    scm {
                        connection.set("scm:git:git://github.com/ILYAPROKOFEV101/UIkitIlya.git")
                        developerConnection.set("scm:git:ssh://github.com:ILYAPROKOFEV101/UIkitIlya.git")
                        url.set("https://github.com/ILYAPROKOFEV101/UIkitIlya")
                    }
                }
            }
        }
        
        repositories {
            mavenLocal()
            
            // GitHub Packages (опционально)
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/ILYAPROKOFEV101/UIkitIlya")
                credentials {
                    username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_USERNAME")
                    password = project.findProperty("gpr.token") as String? ?: System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}


dependencies {
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))
    
    // Core Android
    implementation(libs.androidx.core.ktx)
    
    // Compose UI
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("androidx.compose.material:material-icons-extended:1.5.4")
    
    // Debug tools
    debugImplementation(libs.androidx.ui.tooling)
}
