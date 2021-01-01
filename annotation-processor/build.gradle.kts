import com.nekkan.commands.dependencyloader.Dependencies

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependencies.AnnotationProcessing.kotlinPoet)
}
