buildscript {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath(libs.android.gradlePluginClasspath)
        classpath(libs.kotlin.gradlePluginClasspath)
        classpath(libs.google.hilt.gradlePluginClasspath)
        classpath(libs.gradleVersions.gradlePluginClasspath)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
