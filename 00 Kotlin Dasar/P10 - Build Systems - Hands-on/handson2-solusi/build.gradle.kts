// Hands-on 2: Custom Gradle Task

version = "1.0.0"

tasks.register("printProjectInfo") {
    group = "kotlin dasar"
    description = "Mencetak nama project, versi project, dan versi Gradle"

    doLast {
        // Mencetak nama project dari project.name
        println("Nama project: " + project.name)

        // Mencetak versi project dari project.version
        println("Versi project: " + project.version)

        // Mencetak versi Gradle yang sedang digunakan dari gradle.gradleVersion
        println("Versi Gradle: " + gradle.gradleVersion)
    }
}
