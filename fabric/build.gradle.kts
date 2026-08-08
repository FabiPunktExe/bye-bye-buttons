plugins {
    id("multiloader-loader")
    alias(libs.plugins.fabric.loom)
    alias(libs.plugins.minotaur)
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

modrinth {
    token = System.getenv("MODRINTH_TOKEN")
    projectId = "hVGx9VfI"
    versionName = "$version (Fabric ${libs.versions.minecraft.get()})"
    versionNumber = "$version-${libs.versions.minecraft.get()}-fabric"
    versionType = when {
        "alpha" in version.toString() -> "alpha"
        "beta" in version.toString() -> "beta"
        else -> "release"
    }
    uploadFile = tasks.jar.get()
    gameVersions = listOf(libs.versions.minecraft.get())
    loaders = listOf("fabric")
}