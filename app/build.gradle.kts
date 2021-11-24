plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.targetSdkVersion)
    buildToolsVersion = AndroidConfig.buildToolsVersion

    defaultConfig {
        applicationId = "com.harsh.rxandroid"
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = AndroidConfig.testInstrumentRunner
    }

    buildTypes {
        getByName("release") {
            buildConfigField("int", "DB_VERSION", "1")
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            buildConfigField("int", "DB_VERSION", "1")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {

    implementation(Dependencies.Core.kotlinStdlib)
    implementation(Dependencies.Core.ktxCore)
    implementation(Dependencies.Core.appCompat)
    implementation(Dependencies.Ui.material)
    implementation(Dependencies.Ui.constraintLayout)
    implementation(Dependencies.Ui.recyclerView)
//    implementation(Dependencies.Ui.fragment)

    //room
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    implementation(Dependencies.Room.rxjava)
    kapt(Dependencies.Room.compiler)

    //lifecycle
    implementation(Dependencies.Lifecycle.viewmodel)
    implementation(Dependencies.Lifecycle.livedata)
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.common)
    implementation(Dependencies.Lifecycle.reactivestreams)
    kapt(Dependencies.Lifecycle.extension)

    //network
    implementation(Dependencies.Network.rxAndroid)
}