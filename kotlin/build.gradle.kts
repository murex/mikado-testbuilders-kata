import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "1.4.31"
}

group = "murex.com"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.murex.ApplicationKt")
}

dependencies {
    implementation("commons-io:commons-io:2.6")
    implementation("com.google.code.gson:gson:2.8.6")
    testImplementation("org.assertj:assertj-core:3.19.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.7.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

tasks {
    "test"(Test::class) {
        useJUnitPlatform()
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }

    withType<Jar> {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest { attributes["Main-Class"] = application.mainClass }
        dependsOn(configurations.runtimeClasspath)

        from(configurations.runtimeClasspath.get()
            .map { if (it.isDirectory) it else zipTree(it) })

        archiveFileName.set("MikadoTestBuilderKata.jar")
    }
}
