plugins {
    `java-library`
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(getJavaVersionFromParent())
}

dependencies {
    for (dependency in project.project(":common").configurations["implementation"].dependencies) {
        implementation(dependency)
    }
}

sourceSets {
    main {
        val commonMain = project(":common").sourceSets.getByName("main")
        commonMain.java.srcDirs.forEach(java::srcDir)
        commonMain.resources.srcDirs.forEach(resources::srcDir)
    }
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