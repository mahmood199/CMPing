rootProject.name = "MidJourneyImagesComposeMultiplatform"

include(":androidApp")
include(":shared")
include(":wearApp")
include(":televisionApp")
include(":automotiveApp")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }

    plugins {
        val kotlinVersion = "1.9.20"
        val agpVersion = "8.1.2"
        val composeVersion = "1.5.10"

        kotlin("multiplatform").version(kotlinVersion)
        id("com.android.library").version(agpVersion)
        id("org.jetbrains.compose").version(composeVersion)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
