pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "advent-of-craft"
include(
    "week02",
    "week03",
    "week04",
    "week05",
    "week06",
    "week07"
)
project(":week02").name = "fizzbuzz"
project(":week03").name = "accountability"
project(":week04").name = "password-validation"
project(":week05").name = "fizzbuzz-part3"
project(":week06").name = "documents"
project(":week07").name = "fizzbuzz-part5"