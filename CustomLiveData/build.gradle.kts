plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

android {
    namespace = "util.custom.listlivedata"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "com.github.stellar-suisei"
                artifactId = "custom-live-data"
                version = "1.0.0"

                pom {
                    name = "Custom Live Data"
                    description = "LiveData's extended library"
                    url = "https://github.com/stellar-suisei/custom-live-data"
                    licenses {
                        license {
                            name = "The Apache License, Version 2.0"
                            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                        }
                    }
                    developers {
                        developer {
                            id = "stellar-suisei"
                            name = "Hyesung O"
                            email = "reuiralara@gmail.com"
                        }
                    }
                    scm {
                        connection = "scm:git:git://github.com/stellar-suisei/custom-live-data.git"
                        developerConnection = "scm:git:ssh://git@github.com/stellar-suisei/custom-live-data.git"
                        url = "https://github.com/stellar-suisei/custom-live-data/"
                    }
                }

            }
        }
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}