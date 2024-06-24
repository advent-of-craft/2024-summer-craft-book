pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "summer-craft-book-2024"
include(
    "week01",
    "week02-exercise1",
    "week02-exercise2",
    "week03-exercise1",
    "week03-exercise2",
    "week04",
    "week05-exercise1",
    "week05-exercise2",
    "week06-exercise1",
    "week06-exercise2",
    "week06-exercise3",
    "week07-exercise1",
    "week07-exercise2"
)
project(":week01").name = "movie-store"
project(":week02-exercise1").name = "fizzbuzz"
project(":week02-exercise2").name = "bookstore"
project(":week03-exercise1").name = "client"
project(":week03-exercise2").name = "cache"
project(":week04").name = "password-validation"
project(":week05-exercise1").name = "fizzbuzz-comes-back"
project(":week05-exercise2").name = "commandprocessor"
project(":week06-exercise1").name = "documents"
project(":week06-exercise2").name = "reportgenerator"
project(":week06-exercise3").name = "orderprocessor"
project(":week07-exercise1").name = "fizzbuzz-comes-back-again"
project(":week07-exercise2").name = "allproperties"