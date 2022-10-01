pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")
//include(":data")
//include(":core")
//include(":common")

rootProject.name = "Vaos"

enableFeaturePreview("VERSION_CATALOGS")
include(":core")
