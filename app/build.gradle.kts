plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinParcelizePlugin)
    id(BuildPlugins.ktlintPlugin)
    id(BuildPlugins.jacocoAndroid)
    id(BuildPlugins.kapt)
    id(BuildPlugins.daggerHilt)
}

jacoco {
    toolVersion = Versions.jacoco
}

android {

    compileSdk = AndroidSdk.compileSdkVersion
    android.buildFeatures.dataBinding = true
    android.buildFeatures.viewBinding = true

    defaultConfig {
        applicationId = "com.fasohlabs.unrd"
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion
        versionCode = AndroidSdk.versionCode
        versionName = AndroidSdk.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    testOptions {
        animationsDisabled = true
        unitTests.apply {
            isReturnDefaultValues = true
            isIncludeAndroidResources = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    dependencies {
        implementation(project(":domain"))
        implementation(project(":core"))
        implementation(project(":data:database"))
        implementation(project(":data:network"))

        implementation(Libraries.activityKtx)
        implementation(Libraries.liveData)

        implementation(Libraries.exoplayerCore)
        implementation(Libraries.exoplayerDash)
        implementation(Libraries.exoplayerUi)

        implementation(Libraries.glide)
        kapt(Libraries.glideCompiler)

        implementation(Libraries.shimmer)

        implementation(Libraries.appCompat)
        implementation(Libraries.constraintLayout)
        implementation(Libraries.materialComponents)

        implementation(Libraries.dagger)
        kapt(Libraries.daggerCompiler)

        androidTestImplementation(TestLibraries.testRunner)
        androidTestImplementation(TestLibraries.espresso)
        androidTestImplementation(TestLibraries.annotation)

        testImplementation(TestLibraries.junit4)
        testImplementation(TestLibraries.mockitoKotlin)
        testImplementation(TestLibraries.mockito)
        testImplementation(TestLibraries.junit4)
        testImplementation(TestLibraries.archCore)
    }
}