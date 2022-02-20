plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kapt)
    id(BuildPlugins.jacocoAndroid)
}

android {
    compileSdk = AndroidSdk.compileSdkVersion
    buildToolsVersion = AndroidSdk.buildVersionTool

    defaultConfig {
        minSdk = AndroidSdk.minSdkVersion
        targetSdk = AndroidSdk.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }

    testOptions {
        animationsDisabled = true
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildTypes {
        getByName("debug") {
            isTestCoverageEnabled = false
            buildConfigField("String", "BASE_URL", "\"https://s3-eu-west-1.amazonaws.com/unrd-scratch/\"")
            buildConfigField("long", "HOST_READ_TIMEOUT", "60")
            buildConfigField("long", "HOST_CONNECT_TIMEOUT", "60")
        }

        getByName("release") {
            isMinifyEnabled = true
            buildConfigField("String", "BASE_URL", "\"https://s3-eu-west-1.amazonaws.com/unrd-scratch/\"")
            buildConfigField("long", "HOST_READ_TIMEOUT", "60")
            buildConfigField("long", "HOST_CONNECT_TIMEOUT", "60")
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
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    sourceSets {
        map { it.java.srcDir("src/${it.name}/kotlin") }
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))

    implementation(Libraries.okhttp)
    implementation(Libraries.okhttpLogger)

    implementation(Libraries.retrofit)
    implementation(Libraries.gsonConverter)

    implementation(Libraries.dagger)
    kapt(Libraries.daggerCompiler)

    testImplementation(TestLibraries.junit4)
    testImplementation(TestLibraries.mockito)
    testImplementation(TestLibraries.mockitoKotlin)
    testImplementation(TestLibraries.coroutineTest)
    testImplementation(TestLibraries.mockWebServer)
}