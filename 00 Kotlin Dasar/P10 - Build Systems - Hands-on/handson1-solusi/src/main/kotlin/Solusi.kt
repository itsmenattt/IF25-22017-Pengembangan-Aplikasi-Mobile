import java.util.Properties

// Hands-on 1: Resource & Packaging

fun main() {
    // Membaca InputStream dari resource app.properties melalui classpath classloader
    val inputStream = object {}.javaClass.classLoader.getResourceAsStream("app.properties")

    // Memuat properti dari inputStream ke dalam objek java.util.Properties
    val properties = Properties()
    properties.load(inputStream)

    // Menampilkan properti nama dan versi aplikasi yang telah dibaca
    println("Nama aplikasi: ${properties.getProperty("app.name")}")
    println("Versi: ${properties.getProperty("app.version")}")
}
