import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.findByType

abstract class MultiloaderRootExtension {
    abstract val javaVersion: Property<Int>
}

fun Project.getRootExtensionFromParent(): MultiloaderRootExtension {
    val parentProject = parent ?: error("Common project must have a parent project")
    return parentProject.extensions.findByType<MultiloaderRootExtension>()
        ?: error("multiloader extension of root plugin in parent project must be configured")
}

fun Project.getJavaVersionFromParent() = getRootExtensionFromParent().javaVersion.get()