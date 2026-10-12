plugins {
    java
    checkstyle
}

group = "dev.andrej"
version = "0.1.0"

java {
    toolchain {
        // Gradle сам найдёт установленный corretto-21; если не найдёт — см. README, раздел «Если сборка не видит JDK 21».
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // BOM фиксирует согласованные версии всех модулей JUnit 5
    testImplementation(platform("org.junit:junit-bom:5.11.4"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    // AssertJ — стандарт читаемых assert'ов в Java-мире (assertThat(x).isEqualTo(y))
    testImplementation("org.assertj:assertj-core:3.27.3")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

checkstyle {
    toolVersion = "10.21.1"
    configFile = file("config/checkstyle/checkstyle.xml")
    maxWarnings = 0
    isIgnoreFailures = false
}
