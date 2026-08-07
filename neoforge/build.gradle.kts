plugins {
    id("multiloader-loader")
    alias(libs.plugins.neoforge.moddev)
}

neoForge {
    version = libs.versions.neoforge.neoforge.get()

    mods {
        create("bye_bye_buttons") {
            sourceSet(sourceSets.main.get())
        }
    }

    runs {
        create("client") {
            systemProperty("neoforge.enabledGameTestNamespaces", "bye_bye_buttons")
            client()
        }
    }
}

tasks {
    processResources {
        filesMatching("META-INF/neoforge.mods.toml") {
            expand(
                "version" to version,
                "neoforge_version" to libs.versions.neoforge.neoforge.get(),
                "neoforge_loader_version" to libs.versions.neoforge.loader.get(),
                "minecraft_version" to libs.versions.minecraft.get()
            )
        }
    }
}