plugins {
    id("multiloader-common")
    alias(libs.plugins.neoforge.moddev)
}

neoForge {
    neoFormVersion = libs.versions.neoforge.neoform.get()
}

dependencies {
    implementation(libs.fabric.mixin)
    implementation(libs.mixinExtras)
    annotationProcessor(libs.mixinExtras)
}