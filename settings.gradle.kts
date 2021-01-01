rootProject.name = "commands"
enableFeaturePreview("GRADLE_METADATA")

pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        maven(url = "https://maven.fabricmc.net/") {
            name = "FabricMC"
        }
    }
}

includeBuild("dependency-loader")
include(":common", ":annotation-processor")
