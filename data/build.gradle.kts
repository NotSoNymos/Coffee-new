plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    //id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlin-kapt")

}

android {
    namespace = "com.compose.data"
    compileSdk = 35

    defaultConfig {
        minSdk = 35

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging{
        resources{
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "/META-INF/gradle/incremental.annotation.processors"
        }
    }
}

dependencies {
    implementation(project(":models"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //ksp(libs.hilt.android.compiler)
    kapt(libs.hilt.android.compiler)

    implementation(libs.hilt.android.compiler)
    implementation(libs.hilt.android)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.kotlinx.serialization.json)
    implementation(kotlin("reflect"))
}

//Disable test auto-generation
tasks.configureEach {
    if (this.name == "lint") {
        this.enabled = false
    }
    if (this.name.contains("Test")) {
        this.enabled = false
    }
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}