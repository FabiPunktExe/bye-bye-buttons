plugins {
    `java-library`
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(getJavaVersionFromParent())
}

tasks {
    compileJava {
        options.release = getJavaVersionFromParent()
        options.encoding = "UTF-8"
    }

    jar {
        archiveFileName = "${rootProject.name}-${project.version}-${project.name}.jar"
    }
}