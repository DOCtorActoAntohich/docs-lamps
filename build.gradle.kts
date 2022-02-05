import net.minecraftforge.gradle.user.UserBaseExtension

buildscript {
    repositories {
        mavenCentral()
        maven {
            name = "forge"
            setUrl("https://maven.minecraftforge.net/")
        }
    }
    dependencies {
        classpath("net.minecraftforge.gradle:ForgeGradle:2.3-SNAPSHOT")
    }
}

plugins {
    id("com.matthewprenger.cursegradle") version "1.1.0"
    id("maven-publish")
}
apply {
    plugin("net.minecraftforge.gradle.forge")
}

version = "1.0"
group = "doc"


val mcVersion = "1.12.2"
val forgeVersion = "14.23.5.2847"
val mcFullVersion = "$mcVersion-$forgeVersion"
val modVersion = "1.0"
version = "$mcVersion-$modVersion"

configure<BasePluginConvention> {
    archivesBaseName = "docslamps"
}

fun minecraft(configure: UserBaseExtension.() -> Unit) = project.configure(configure)

minecraft {
    version = mcFullVersion
    mappings = "stable_39"
    runDir = "run"
}

repositories {
    maven {
        name = "CCL Maven New"
        setUrl("https://minecraft.curseforge.com/api/maven")
    }
    maven {
        name = "ChickenBones maven"
        setUrl("http://chickenbones.net/maven/")
    }
}

dependencies {
    "compile"("codechicken:ChickenASM:1.12-1.0.2.9")
    "compile"(files("etc/CodeChickenLib-1.12.2-3.2.3.358-universal.jar"))
    "compile"(files("etc/jei_1.12.2-4.16.1.301.jar"))

    "compile"(files("etc/CraftTweaker2-1.12-4.1.20.670.jar"))
    "compile"(files("etc/theoneprobe-1.12-1.4.28.jar"))
    "compile"(files("etc/CTM-MC1.12.2-1.0.2.31.jar"))
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
