@file:Suppress("PropertyName", "SpellCheckingInspection")

import io.izzel.taboolib.gradle.BUKKIT_ALL
import io.izzel.taboolib.gradle.UNIVERSAL
import io.izzel.taboolib.gradle.VELOCITY
import io.izzel.taboolib.gradle.BUNGEE
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    id("io.izzel.taboolib") version "2.0.11"
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}

subprojects {
    apply<JavaPlugin>()
    apply(plugin = "io.izzel.taboolib")
    apply(plugin = "org.jetbrains.kotlin.jvm")

    // TabooLib 配置
    taboolib {
        env {
            install(UNIVERSAL, BUKKIT_ALL, VELOCITY, BUNGEE)
        }
        version { taboolib = "6.1.1-beta17" }
    }

    // 全局仓库
    repositories {
        mavenLocal()
        mavenCentral()
    }
    // 全局依赖
    dependencies {
        compileOnly(kotlin("stdlib"))
    }

    // 编译配置
    java {
        withSourcesJar()
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjvm-default=all", "-Xextended-compiler-checks")
        }
    }
}

gradle.buildFinished {
    buildDir.deleteRecursively()
}