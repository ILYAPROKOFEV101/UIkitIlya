# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.kts.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep all public classes and methods
-keep public class * {
    public *;
}

# Keep Compose composables
-keep class androidx.compose.** { *; }
-keep class kotlin.coroutines.** { *; }

