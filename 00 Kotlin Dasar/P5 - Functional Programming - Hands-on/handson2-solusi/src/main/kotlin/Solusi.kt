// Hands-on 2: Lambda vs Function Reference
// Solusi: Membandingkan penggunaan lambda biasa dengan function reference (::namaFungsi)

// Fungsi pembantu untuk mengecek apakah panjang string bernilai genap
fun isEvenLength(s: String): Boolean = s.length % 2 == 0

// Fungsi pembantu untuk mengubah string menjadi huruf kapital
fun toUpper(s: String): String = s.uppercase()

fun main() {
    // Daftar nama mahasiswa yang akan diolah
    val mahasiswa = listOf("Andi", "Budi", "Citra", "Dewi", "Eka", "Fajar")

    // Pipeline 1: Menggunakan sintaks lambda inline { ... }
    val hasilLambda: List<String> = mahasiswa
        // Menyaring nama dengan panjang genap menggunakan parameter implisit 'it'
        .filter { it.length % 2 == 0 }
        // Mengubah string menjadi huruf kapital menggunakan parameter implisit 'it'
        .map { it.uppercase() }

    // Pipeline 2: Menggunakan function reference (::) ke fungsi top-level yang sudah dideklarasikan
    val hasilReference: List<String> = mahasiswa
        // Mereferensikan fungsi isEvenLength sebagai predikat filter
        .filter(::isEvenLength)
        // Mereferensikan fungsi toUpper sebagai fungsi transformasi map
        .map(::toUpper)

    // Menampilkan hasil dari kedua pendekatan
    println("Lambda   : $hasilLambda")
    println("Reference: $hasilReference")

    // Memverifikasi bahwa kedua pendekatan menghasilkan nilai yang identik
    println("Sama? ${hasilLambda == hasilReference}")
}
