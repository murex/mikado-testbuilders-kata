import com.adarshr.gradle.testlogger.TestLoggerExtension
import com.adarshr.gradle.testlogger.TestLoggerPlugin
import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    application
    kotlin("jvm") version "1.8.21"
    id("com.adarshr.test-logger") version "3.2.0"
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.murex.ApplicationKt")
}

dependencies {
    implementation("commons-io:commons-io:2.11.0")
    implementation("com.google.code.gson:gson:2.10.1")
    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Jar> {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest { attributes["Main-Class"] = application.mainClass }
    dependsOn(configurations.runtimeClasspath)

    from(configurations.runtimeClasspath.get()
        .map { if (it.isDirectory) it else zipTree(it) })

    archiveFileName.set("MikadoTestBuilderKata.jar")
}

group = "murex.com"
version = "1.0-SNAPSHOT"

testlogger {
    theme = ThemeType.STANDARD
    showExceptions = true
    showStackTraces = true
    showFullStackTraces = false
    showCauses = true
    slowThreshold = 2000
    showSummary = true
    showSimpleNames = false
    showPassed = true
    showSkipped = true
    showFailed = true
    showStandardStreams = false
    showPassedStandardStreams = true
    showSkippedStandardStreams = true
    showFailedStandardStreams = true
    logLevel = LogLevel.LIFECYCLE
}
