val appGroup: String by project
val appVersion: String by project

val kotlinVersion: String by project
val ktorVersion: String by project
val koinVersion: String by project
val kMongoVersion: String by project
val logbackVersion: String by project

val main = "io.ktor.server.netty.EngineMain"

group =  appGroup
version = appVersion

plugins {
  application
  kotlin("jvm") version "1.3.0"
  id("com.github.johnrengelman.shadow") version "4.0.2"
}

application {
  mainClassName = main
}

repositories {
  mavenLocal()
  jcenter()
  maven { url = uri("https://kotlin.bintray.com/ktor") }
}

dependencies {
  implementation("org.jetbrains.kotlin", "kotlin-stdlib", kotlinVersion)

  implementation("io.ktor", "ktor-server-netty", ktorVersion)
  implementation("io.ktor", "ktor-server-core", ktorVersion)
  implementation("io.ktor", "ktor-jackson", ktorVersion)
  implementation("org.koin", "koin-ktor", koinVersion)
  implementation("org.litote.kmongo", "kmongo", kMongoVersion)
  implementation("org.litote.kmongo", "kmongo-id-jackson", kMongoVersion)

  implementation("ch.qos.logback", "logback-classic", logbackVersion)

  testImplementation("io.ktor", "ktor-server-tests", ktorVersion)
}

kotlin.sourceSets["main"].kotlin.srcDirs("src")
kotlin.sourceSets["test"].kotlin.srcDirs("test")

sourceSets["main"].resources.srcDirs("resources")
sourceSets["test"].resources.srcDirs("testresources")
