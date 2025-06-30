plugins {
    java
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
    id("com.github.johnrengelman.shadow") version "8.1.1"

}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/io.javalin/javalin
    implementation("io.javalin:javalin:6.7.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.17")
}

sonar {
    properties {
        property("sonar.projectKey", "benissimoff_java-project-72")
        property("sonar.organization", "benissimoff")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

tasks.test {
    useJUnitPlatform()
}