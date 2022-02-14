object Versions {

    // Version codes for all the libraries
    const val kotlin = "1.6.0"
    const val appCompat = "1.4.0-rc01"
    const val constraintLayout = "2.1.1"
    const val ktx = "1.7.0"
    const val material = "1.5.0-beta01"

    // Version codes for all the test libraries
    const val junit4 = "4.13.2"
    const val testRunner = "1.4.1-alpha03"
    const val espresso = "3.5.0-alpha03"
    const val annotation = "1.3.0"
    const val androidxJUnit = "1.1.2"
    const val mockitoKotlin = "4.0.0"
    const val mockito = "3.7.7"

    // Gradle Plugins
    const val ktlint = "10.2.0"
    const val detekt = "1.18.0"
    const val spotless = "6.0.0"
    const val dokka = "1.5.31"
    const val gradleVersionsPlugin = "0.39.0"
    const val jacoco = "0.8.7"

    const val roomVersion = "2.2.6"
    const val hiltDagger = "2.38.1"

    const val activityKtx = "1.1.0"
    const val liveData = "2.2.0"

    const val timber = "4.7.1"

    const val coroutines = "1.3.9"
    const val coil = "1.1.1"

    const val retrofit = "2.9.0"
    const val okhttp = "4.9.1"
}

object BuildPlugins {
    // All the build plugins are added here
    const val androidLibrary = "com.android.library"
    const val ktlintPlugin = "org.jlleitschuh.gradle.ktlint"
    const val detektPlugin = "io.gitlab.arturbosch.detekt"
    const val spotlessPlugin = "com.diffplug.spotless"
    const val dokkaPlugin = "org.jetbrains.dokka"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinParcelizePlugin = "org.jetbrains.kotlin.plugin.parcelize"
    const val gradleVersionsPlugin = "com.github.ben-manes.versions"
    const val jacocoAndroid = "com.hiya.jacoco-android"

    const val daggerHilt = "dagger.hilt.android.plugin"
    const val kapt = "kotlin-kapt"

    const val javaLibrary = "java-library"
    const val kotlinLibrary = "kotlin"
}

object Libraries {
    // Any Library is added here
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialComponents = "com.google.android.material:material:${Versions.material}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"

    // hilt
    const val dagger = "com.google.dagger:hilt-android:${Versions.hiltDagger}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltDagger}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltDagger}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltDagger}"

    // lifecycle
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coil = "io.coil-kt:coil:${Versions.coil}"

    //
    const val gson = "com.google.code.gson:gson:2.9.0"

    // Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // OkHttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogger = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
}

object TestLibraries {
    // any test library is added here
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val annotation = "androidx.annotation:annotation:${Versions.annotation}"

    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJUnit}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okhttp}"
}

object AndroidSdk {
    const val minSdkVersion = 21
    const val compileSdkVersion = 31
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
    const val buildVersionTool = "30.0.3"
}