import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)

    kotlin("kapt")
}

android {
    namespace = "com.vnazarov.sportdatatest"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.vnazarov.sportdatatest"
        minSdk = 31
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }
}

dependencies {
    // Retrofit and OkHttp
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.loggingInterceptor)
    implementation(libs.converterGson)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Room
    implementation(libs.roomRuntime)
    kapt(libs.roomCompiler)
    implementation(libs.roomKtx)

    // ViewModel and LiveData
    implementation(libs.lifecycleViewmodelKtx)
    implementation(libs.lifecycleLivedataKtx)

    // Coroutines
    implementation(libs.coroutinesAndroid)

    // Gson
    implementation(libs.gson)

    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":presentation"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}