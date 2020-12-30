import com.nekkan.commands.dependencyloader.Dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("dependency-loader") apply false
    kotlin("jvm") version "1.4.21"
}

allprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "dependency-loader")

    repositories {
        mavenCentral()
        jcenter()
        maven(url = "https://maven.fabricmc.net/") {
            name = "FabricMC"
        }
    }

    dependencies {
        testImplementation(kotlin("test-junit5"))
        testImplementation(Dependencies.JUnit.jupiterApi)
        testRuntimeOnly(Dependencies.JUnit.jupiterEngine)
    }

    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
