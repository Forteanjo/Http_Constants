plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.jetbrains.kotlin.parcelize)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.kotlin.symbol.processing)
}

android {
    namespace = "sco.carlukesoftware.httpconstants"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "sco.carlukesoftware.httpconstants"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        //noinspection EditedTargetSdkVersion
        versionCode = libs.versions.app.versionCode.get().toInt()
        versionName = libs.versions.app.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    kotlinOptions {
        jvmTarget = libs.versions.jvmTarget.get()
    }

    buildFeatures {
        compose = true

        // Disable unused AGP features
        viewBinding = false
        dataBinding = false
//
//        buildConfig = false
//        resValues = false
//        shaders = false
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/DEPENDENCIES"
            excludes += "META-INF/LICENSE"
            excludes += "META-INF/LICENSE.txt"
            excludes += "META-INF/license.txt"
            excludes += "META-INF/NOTICE"
            excludes += "META-INF/NOTICE.txt"
            excludes += "META-INF/notice.txt"
            excludes += "META-INF/ASL2.0"
        }
    }

    sourceSets["main"].java {
        srcDirs(
            "src/main/kotlin",
            "src/common/kotlin",
            "src/debug/kotlin",
            "src/release/kotlin",
            "src/staging/kotlin",
            "src/preproduction/kotlin"
        )
    }
}

dependencies {

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(libs.bundles.androidx.lifecycle)

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)

    implementation(libs.bundles.androidx.material3)
    implementation(libs.androidx.material3.window.size)

    implementation(libs.androidx.navigation.compose)

    implementation(libs.androidx.palette)
    implementation(libs.androidx.window)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.kotlin.reflect)

    // Koin
    implementation(platform(libs.io.koin.bom))
    implementation(libs.bundles.io.koin)
    ksp(libs.io.koin.ksp.compiler)

    // Ktor
    implementation(libs.bundles.io.ktor.client)

    // Local libraries
    implementation(project(":ktor"))

    testImplementation(libs.junit)

    testImplementation(libs.io.koin.test)
    testImplementation(libs.io.koin.test.unit4)
    testImplementation(libs.io.koin.test.unit5)

    androidTestImplementation(composeBom)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

ksp {
    arg("KOIN_CONFIG_CHECK", "true")
}
