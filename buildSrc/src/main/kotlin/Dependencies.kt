object Versions {
    const val kotlin = "1.5.10"
}

object AndroidConfig {
    const val buildToolsVersion = "30.0.2"
    const val targetSdkVersion = 30
    const val minSdkVersion = 16
    const val testInstrumentRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object BuildPlugin {
    private object Version {
        const val buildTool = "4.2.0"
    }

    const val gradleBuildTool = "com.android.tools.build:gradle:${Version.buildTool}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}

object Dependencies {
    object Core {
        private object Version {
            const val ktx = "1.3.1"
            const val appCompat = "1.2.0"
        }

        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        const val ktxCore = "androidx.core:core-ktx:${Version.ktx}"
        const val appCompat = "androidx.appcompat:appcompat:${Version.appCompat}"
    }

    object Ui {
        private object Version {
            const val material = "1.2.1"
            const val constrainLayout = "2.0.1"
            const val recyclerView = "1.2.1"
            const val fragment = "1.4.0"
        }

        const val material = "com.google.android.material:material:${Version.material}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constrainLayout}"
        const val recyclerView = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        const val fragment = "androidx.fragment:fragment-ktx:${Version.fragment}"
    }

    object Room {
        private object Version {
            const val room = "2.3.0"
        }

        const val runtime = "androidx.room:room-runtime:${Version.room}"
        const val compiler = "androidx.room:room-compiler:${Version.room}"
        const val ktx = "androidx.room:room-ktx:${Version.room}"
        const val rxjava = "androidx.room:room-rxjava2:${Version.room}"
    }

    object Lifecycle {
        private object Version {
            const val lifecycle = "2.3.1"
            const val extension = "2.2.0"
        }

        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
        const val common = "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycle}"
        const val extension = "androidx.lifecycle:lifecycle-extensions:${Version.extension}"
        const val reactivestreams = "androidx.lifecycle:lifecycle-reactivestreams:${Version.lifecycle}"
    }

    object Network {
        private object Version {
            const val rxAndroid = "2.1.1"
        }

        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    }
}
