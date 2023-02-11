plugins {
    kotlin("jvm") version "1.8.0"
    java
    id("org.unbroken-dome.test-sets") version "4.0.0"
}

group = "com.neelesh"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation("io.arrow-kt:arrow-core:1.1.2")
}

testSets {
    create("acceptanceTest") {
        dirName = "acceptanceTest"
    }
}

tasks.withType(Test::class.java){
    useJUnitPlatform()
}