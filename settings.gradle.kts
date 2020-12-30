rootProject.name = "commands"
enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
    }
}

includeBuild("dependency-loader")
