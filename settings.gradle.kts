rootProject.name = "bye-bye-buttons"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        maven("https://repo.diruptio.de/repository/maven-public")
        maven("https://maven.fabricmc.net")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

includeBuild("build-logic")
include(":common")
include(":fabric")
include(":neoforge")