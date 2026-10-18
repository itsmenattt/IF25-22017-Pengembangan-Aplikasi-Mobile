// Hands-on 3: Kotlin Sugar - try sebagai expression, require(), error(), multi-catch

data class Tiket(val nama: String, val umur: Int)

fun parseTiket(input: String): Tiket {
    val bagian = input.split("/")

    // Memastikan format input terdiri dari 2 bagian (nama dan umur)
    require(bagian.size == 2) { "Format harus 'nama/umur', diterima: $input" }

    val nama = bagian[0]

    // Menggunakan try sebagai expression untuk mengonversi string umur menjadi angka Int
    val umur: Int = try {
        bagian[1].toInt()
    } catch (e: NumberFormatException) {
        error("Umur tidak valid: ${bagian[1]}")
    }

    // Validasi tambahan: nama tidak boleh kosong dan umur tidak boleh negatif
    require(nama.isNotEmpty()) { "Nama tidak boleh kosong" }
    require(umur >= 0) { "Umur tidak boleh negatif: $umur" }

    return Tiket(nama, umur)
}

fun main() {
    val inputs = listOf("Budi/25", "Siti/17", "format-salah", "Andi/bukan-angka", "/30")

    for (input in inputs) {
        // Multi-catch untuk menangani berbagai kemungkinan jenis error secara terpisah
        try {
            val tiket = parseTiket(input)
            println("Berhasil parsing: $tiket")
        } catch (e: IllegalArgumentException) {
            println("Error argumen: ${e.message}")
        } catch (e: IllegalStateException) {
            println("Error state/konversi: ${e.message}")
        }
    }
}
