plugins {
    id("multiloader-root")
    id("multiloader-common") apply false
    id("multiloader-loader") apply false
    alias(libs.plugins.fabric.loom) apply false
    alias(libs.plugins.neoforge.moddev) apply false
}

group = "de.fabiexe"
version = "1.0.5"

multiloader {
    javaVersion = libs.versions.java.get().toInt()
}

subprojects {
    group = rootProject.group
    version = rootProject.version
}