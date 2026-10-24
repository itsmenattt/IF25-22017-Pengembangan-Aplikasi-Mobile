import kotlin.reflect.full.memberProperties

// Hands-on 1: Inspeksi Kelas dengan KClass

data class Product(val nama: String, val harga: Int)

fun main() {
    val product = Product("Kopi Susu", 18000)

    // Mengambil KClass dari objek product
    val kClass = product::class

    // Mencetak nama kelas
    println("Kelas: ${kClass.simpleName}")

    // Menampilkan daftar nama seluruh properti milik kelas Product lewat reflection
    println("Properties:")
    for (prop in kClass.memberProperties) {
        println("- ${prop.name}")
    }
}
