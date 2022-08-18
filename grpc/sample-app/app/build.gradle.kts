import com.google.protobuf.gradle.*

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.19")
    }
}

plugins {
    idea
    kotlin("jvm") version "1.7.10"
    application
    id("com.google.protobuf") version "0.8.19"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("com.google.protobuf:protobuf-kotlin:3.21.5")
    implementation("io.grpc:grpc-protobuf:1.48.1")
    implementation("io.grpc:grpc-stub:1.48.1")

    // idk, why its not transient dependency or something
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
    
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    testImplementation("io.grpc:grpc-testing:1.48.1")
}

application {
    // Define the main class for the application.
    mainClass.set("com.example.sample.AppKt")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.5"
    }

    // https://github.com/google/protobuf-gradle-plugin/blob/master/examples/exampleKotlinDslProject/build.gradle.kts
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.48.1"
        }
    }

    // https://developers.googleblog.com/2021/11/announcing-kotlin-support-for-protocol.html
    generateProtoTasks {
        all().forEach {
            it.builtins {
                id("kotlin")
            }

            // https://github.com/google/protobuf-gradle-plugin/blob/master/examples/exampleKotlinDslProject/build.gradle.kts
            it.plugins {
                id("grpc")
            }
        }
    }

}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        apiVersion = "1.7"
        languageVersion = "1.7"
        jvmTarget = "17"
    }
}

tasks.withType<JavaCompile>().configureEach {
    sourceCompatibility = "17"
    targetCompatibility = "17"
}
