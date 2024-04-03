// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidKotlin) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinxSerializationJson)
    alias(libs.plugins.ksp)
//    id("com.android.application") version "8.2.2" apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
//    id("com.android.library") version "8.2.2" apply false
//    id("org.jetbrains.kotlin.plugin.serialization") version "1.5.0"


}