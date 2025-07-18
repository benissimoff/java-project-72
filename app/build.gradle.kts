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
    // https://mvnrepository.com/artifact/org.projectlombok/lombok
    implementation("org.projectlombok:lombok:1.18.38")
    annotationProcessor("org.projectlombok:lombok:1.18.38")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/io.javalin/javalin
    implementation("io.javalin:javalin:6.7.0")
//    implementation("io.javalin:javalin-bundle:6.6.0")
    implementation("io.javalin:javalin-rendering:6.6.0")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    implementation("org.slf4j:slf4j-simple:2.0.17")
    implementation("com.zaxxer:HikariCP:6.3.0")
    // https://mvnrepository.com/artifact/com.h2database/h2
    implementation("com.h2database:h2:2.3.232")
// https://mvnrepository.com/artifact/org.postgresql/postgresql
    implementation("org.postgresql:postgresql:42.7.7")
    implementation("gg.jte:jte:3.2.1")
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