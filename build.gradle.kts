plugins {
    id("java")
}

group = "groupId"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.10.0")
    implementation("io.rest-assured:rest-assured:5.4.0")
    implementation("io.rest-assured:json-path:5.4.0")
    implementation("io.rest-assured:xml-path:5.4.0")
    implementation("org.hamcrest:hamcrest:2.2")
    implementation("io.rest-assured:json-schema-validator:5.4.0")
    implementation("com.fasterxml.jackson.core:jackson-core:2.17.1")}

tasks.test {
    useJUnitPlatform()
}