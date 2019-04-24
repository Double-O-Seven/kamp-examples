import groovy.lang.Closure

plugins {
    kotlin("jvm") version "1.3.11"
    java
    `build-scan`
    id("com.palantir.git-version") version "0.12.0-rc2"
}

val kampVersion: String by extra { "1.0.0-rc8" }

val gitVersion: Closure<String> by extra

buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
}

allprojects {
    version = gitVersion()

    group = "ch.leadrian.samp.kamp"

    repositories {
        mavenCentral()
        mavenLocal()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "java")

    tasks {
        compileKotlin {
            sourceCompatibility = "1.8"
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xjvm-default=compatibility")
            }
        }
    }

    dependencies {
        implementation(group = "ch.leadrian.samp.kamp", name = "kamp-core", version = kampVersion)

        implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib-jdk8", version = "1.3.11")
        implementation(group = "com.netflix.governator", name = "governator", version = "1.17.5")
        implementation(group = "com.google.inject", name = "guice", version = "4.2.2")
        implementation(group = "javax.inject", name = "javax.inject", version = "1")
        implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.25")
        implementation(group = "org.slf4j", name = "slf4j-log4j12", version = "1.7.25")
    }

}
