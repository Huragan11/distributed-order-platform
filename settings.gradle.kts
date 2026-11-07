plugins {
    // Downloads a missing JDK (e.g. 21) when a module requests it via a Java toolchain
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}

rootProject.name = "distributed-order-platform"

dependencyResolutionManagement {
    // Repositories are declared once here; modules are not allowed to add their own
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        mavenCentral()
    }
}
