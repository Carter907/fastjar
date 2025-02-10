

plugins {
    id("java")
    id("com.gradleup.shadow") version("9.0.0-beta8")

}

group = "com.carter.speers"
version = "0.0.0"

repositories {
    mavenCentral()
}
tasks.shadowJar {
    manifest {
        attributes(
            "Main-Class" to "com.carter.speers.Main" // Replace with your main class
        )
    }
    archiveBaseName.set("fastjar") // Custom base name
    archiveVersion.set("") // Custom version
    archiveClassifier.set("") // Custom classifier
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}