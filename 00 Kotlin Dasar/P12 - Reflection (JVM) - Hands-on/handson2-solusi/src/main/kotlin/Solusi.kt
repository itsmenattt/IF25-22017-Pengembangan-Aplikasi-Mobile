import kotlin.reflect.full.memberProperties

// Hands-on 2: Baca Nilai Property Dinamis

data class Mahasiswa(val nim: String, val nama: String, val ipk: Double)

fun printFields(obj: Any) {
    // Mengambil KClass dari objek
    val kClass = obj::class

    // Iterasi setiap properti dan mengambil nilainya secara dinamis menggunakan getter reflection
    for (property in kClass.memberProperties) {
        val value = property.getter.call(obj)
        println("${property.name} = $value")
    }
}

fun main() {
    val mhs = Mahasiswa("122140000", "Budi Santoso", 3.75)
    printFields(mhs)
}
