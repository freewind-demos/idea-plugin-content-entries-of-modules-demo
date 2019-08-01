package example

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ModuleRootManager

class MyComponent(private val currentProject: Project) : ProjectComponent {

    override fun projectOpened() {
        println("> projectOpened")

        println("Current project: $currentProject")

        val modules = ModuleManager.getInstance(currentProject).modules
        println("modules:")

        modules.forEach { module ->
            println("------- ${module.name} --------")
            println("path: ${module.moduleFilePath}")
            val contentEntries = ModuleRootManager.getInstance(module).contentEntries
            println("content entries:")
            contentEntries.forEach { entry ->
                println("- ${entry.file}")
            }
        }
    }

}