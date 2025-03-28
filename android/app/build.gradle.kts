plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
    id("com.google.gms.google-services") // ✅ Correct placement
}

android {
    namespace = "com.example.firebase_auth_firestore"
    compileSdk = 35 // ✅ Set explicitly

    ndkVersion = "29.0.13113456" // ✅ Fix NDK issue

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.firebase_auth_firestore"
        minSdk = 23  // ✅ Firebase requires minSdk 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    // buildTypes {
    //     release {
    //         isMinifyEnabled = false
    //         proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

    //         // ✅ Use debug signing config to avoid build errors
    //         signingConfig = signingConfigs.getByName("debug")
    //     }
    // }

    buildTypes {
        release {
            isMinifyEnabled = true  // ✅ Enable ProGuard/R8
            isShrinkResources = true  // ✅ Correct Kotlin syntax
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")

            signingConfig = signingConfigs.getByName("debug")
        }
    }

}

flutter {
    source = "../.."
}
