plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins.register("dependency-loader") {
        id = "dependency-loader"
        implementationClass = "com.nekkan.commands.dependencyloader.Dependencies"
    }
}
