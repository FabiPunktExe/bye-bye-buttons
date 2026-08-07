plugins {
    id("multiloader-loader")
    alias(libs.plugins.fabric.loom)
}

repositories {
    maven("https://maven.terraformersmc.com") // Modmenu
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.loader)
    implementation(libs.modmenu)
}

tasks {
    processResources {
        filesMatching("fabric.mod.json") {
            expand(
                "version" to version,
                "java_version" to libs.versions.java.get(),
                "minecraft_version" to libs.versions.minecraft.get()
            )
        }
    }
}