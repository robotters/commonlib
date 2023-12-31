val libVersion: String by rootProject.extra

plugins {
  // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
  id("org.jetbrains.kotlin.jvm") version "1.4.31"

  // Apply the java-library plugin for API and implementation separation.
  `java-library`
  // Maven Publish
  `maven-publish`
}

repositories {
  // Use Maven Central for resolving dependencies.
  mavenCentral()
}

dependencies {
  // Align versions of all Kotlin components
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

  // Use the Kotlin JDK 8 standard library.
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

  // This dependency is used internally, and not exposed to consumers on their own compile
  // classpath.
  implementation("com.google.guava:guava:30.0-jre")

  // Use the Kotlin test library.
  testImplementation("org.jetbrains.kotlin:kotlin-test")

  // Use the Kotlin JUnit integration.
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

  // This dependency is exported to consumers, that is to say found on their compile classpath.
  api("org.apache.commons:commons-math3:3.6.1")
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = "github.robotters"
      version = System.getenv("VERSION")
      artifactId = "commonlib"
      from(components["java"])
    }
  }

  repositories {
    maven {
      url = uri("https://maven.pkg.github.com/robotters/commonlib")
      name = "GHPackages"
      credentials {
        username = System.getenv("USERNAME")
        password = System.getenv("TOKEN")
      }
    }
  }
}
