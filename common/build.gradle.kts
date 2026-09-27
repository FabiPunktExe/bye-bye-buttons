plugins {
    id("convention")
    alias(libs.plugins.multiloader.common)
    alias(libs.plugins.fabric.loom)
}

multiloader {
    projectName = rootProject.name
    javaVersion = libs.versions.java.get().toInt()
}

repositories {
    maven("https://repo.diruptio.de/repository/maven-public") // config
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.mixin)
    implementation(libs.mixinExtras)
    annotationProcessor(libs.mixinExtras)
    api(libs.config)
}