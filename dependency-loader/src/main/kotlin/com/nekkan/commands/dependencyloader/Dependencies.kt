package com.nekkan.commands.dependencyloader

import org.gradle.api.Plugin
import org.gradle.api.Project

class Dependencies: Plugin<Project> {

    companion object {
        // TODO
    }

    object JUnit {
        const val version = "5.6.0"
        const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:5.6.0"
        const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:5.6.0"
    }

    override fun apply(target: Project) {
        /* no-op */
    }

}
