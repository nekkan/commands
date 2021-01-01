package com.nekkan.commands.dependencyloader

import org.gradle.api.Plugin
import org.gradle.api.Project

class Dependencies: Plugin<Project> {

    object AnnotationProcessing {
        const val kotlinPoet = "com.squareup:kotlinpoet:1.7.2"
    }

    object JUnit {
        const val version = "5.6.0"
        const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$version"
        const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$version"
    }

    override fun apply(target: Project) {
        /* no-op */
    }

}
