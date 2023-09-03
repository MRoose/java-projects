import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.10"
}

group = "com.github.mroose"
version = "latest"

kotlin {
    jvmToolchain(17)
}

val koraVersion = "0.14.5"

val kotlinVersion = "1.9.10"
val slf4jApiVersion = "2.0.7"
val mapstructVersion = "1.5.5.Final"
val jakartaEeBomVersion = "10.0.0"
val apacheCommonsLangVersion = "3.13.0"
val apacheCommonsIoVersion = "2.13.0"
val googleLibrariesBomVersion = "26.22.0"
val jacksonBomVersion = "2.15.2"
val jsonPathVersion = "2.8.0"
val okHttpBomVersion = "4.11.0"

val junitBomVersion = "5.10.0"
val mockitoBomVersion = "5.5.0"
val assertjBomVersion = "3.24.2"
val testcontainersBomVersion = "1.19.0"

dependencies {
    implementation(platform("ru.tinkoff.kora:kora-parent:$koraVersion"))
    annotationProcessor("ru.tinkoff.kora:annotation-processors:$koraVersion")
    implementation("ru.tinkoff.kora:http-server-undertow")
    implementation("ru.tinkoff.kora:json-module")
    implementation("ru.tinkoff.kora:micrometer-module")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.slf4j:slf4j-api:$slf4jApiVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    implementation(platform("jakarta.platform:jakarta.jakartaee-bom:$jakartaEeBomVersion"))
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.apache.commons:commons-lang3:$apacheCommonsLangVersion")
    implementation("commons-io:commons-io:$apacheCommonsIoVersion")
    implementation(platform("com.google.cloud:libraries-bom:$googleLibrariesBomVersion"))
    implementation("com.google.guava:guava")
    implementation("com.google.code.gson:gson")
    implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonBomVersion"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.jayway.jsonpath:json-path:$jsonPathVersion")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:$okHttpBomVersion"))
    implementation("com.squareup.okhttp3:okhttp")

    testImplementation(platform("org.junit:junit-bom:$junitBomVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation(platform("org.mockito:mockito-bom:$mockitoBomVersion"))
    testImplementation("org.mockito:mockito-core")
    testImplementation(platform("org.assertj:assertj-bom:$assertjBomVersion"))
    testImplementation("org.assertj:assertj-core")
    testImplementation(platform("org.testcontainers:testcontainers-bom:$testcontainersBomVersion"))
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}