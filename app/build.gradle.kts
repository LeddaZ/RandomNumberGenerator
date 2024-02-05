plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

fun getCommitCount(): Int {
    val stdout = org.apache.commons.io.output.ByteArrayOutputStream()
    project.exec {
        commandLine = "git rev-list --count HEAD".split(" ")
        standardOutput = stdout
    }
    return Integer.parseInt(String(stdout.toByteArray()).trim())
}

fun getCommitHash(): String {
    val stdout = org.apache.commons.io.output.ByteArrayOutputStream()
    project.exec {
        commandLine = "git rev-parse --short HEAD".split(" ")
        standardOutput = stdout
    }
    return String(stdout.toByteArray()).trim()
}

android {
    namespace = "com.leddaz.rng"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.leddaz.rng"
        minSdk = 21
        targetSdk = 34
        versionCode = getCommitCount()
        versionName = "1.0.0 (" + getCommitHash() + ")"
    }

    buildTypes {
        getByName("release") {
            // Includes the default ProGuard rules files.
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
        getByName("debug") {
            applicationIdSuffix = ".dev"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

    @Suppress("UnstableApiUsage")
    androidResources {
        generateLocaleConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}
