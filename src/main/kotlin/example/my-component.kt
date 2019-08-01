package example

import com.intellij.openapi.components.ProjectComponent
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.project.Project

class MyComponent(private val currentProject: Project) : ProjectComponent {

    override fun projectOpened() {
        println("> projectOpened")

        println("Current project: $currentProject")

        val modules = ModuleManager.getInstance(currentProject).modules
        println("modules:")

        modules.forEach { module ->
            println("${module.name}: ${module.moduleFilePath}")
        }
    }

}