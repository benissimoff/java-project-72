plugins {
    java
    application
    checkstyle
    id("org.sonarqube") version "6.2.0.5505"
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}



dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
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