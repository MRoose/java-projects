import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.spring") version "2.0.0"
    id("org.springframework.boot") version "3.0.0"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.graalvm.buildtools.native") version "0.10.2"
}

group = "com.github.mroose"
version = "latest"

kotlin {
    jvmToolchain(21)
}

val springCloudVersion = "2023.0.2"
val springdocOpenapiVersion = "2.5.0"

val kotlinVersion = "2.0.0"
val slf4jApiVersion = "2.0.13"
val mapstructVersion = "1.5.5.Final"
val jakartaEeBomVersion = "10.0.0"
val apacheCommonsLangVersion = "3.14.0"
val apacheCommonsIoVersion = "2.16.1"
val googleLibrariesBomVersion = "26.40.0"
val jacksonBomVersion = "2.17.1"
val jsonPathVersion = "2.9.0"
val okHttpBomVersion = "4.12.0"

val junitBomVersion = "5.10.2"
val mockitoBomVersion = "5.12.0"
val assertjBomVersion = "3.26.0"
val testcontainersBomVersion = "1.19.8"

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    runtimeOnly("com.h2database:h2")
    implementation("org.springframework.kafka:spring-kafka")

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.slf4j:slf4j-api:$slf4jApiVersion")
    implementation("org.mapstruct:mapstruct:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")
    implementation(platform("org.springdoc:springdoc-openapi:$springdocOpenapiVersion"))
    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui")
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

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.squareup.okhttp3:mockwebserver")

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
        jvmTarget = "21"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}