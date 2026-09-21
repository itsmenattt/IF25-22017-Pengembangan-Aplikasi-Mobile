// Hands-on 2: Control Flow — when sebagai Expression
// Solusi: Menggunakan single-expression function dan when expression

// Menggunakan single-expression function (=) dan when sebagai expression untuk mengevaluasi nilai
fun gradeOf(nilai: Int): String = when (nilai) {
    // Mengecek rentang nilai 90 sampai 100 menggunakan operator in ..
    in 90..100 -> "A"
    // Mengecek rentang nilai 80 sampai 89
    in 80..89 -> "B"
    // Mengecek rentang nilai 70 sampai 79
    in 70..79 -> "C"
    // Mengecek rentang nilai 60 sampai 69
    in 60..69 -> "D"
    // Cabang fallback jika nilai di luar rentang di atas
    else -> "E"
}

fun main() {
    // Membuat list kumpulan nilai mahasiswa yang akan diuji
    val nilaiMahasiswa = listOf(95, 82, 71, 60, 45)
    // Melakukan perulangan untuk setiap nilai dalam list
    for (nilai in nilaiMahasiswa) {
        // Mencetak hasil konversi nilai menjadi huruf mutu (grade)
        println("Nilai $nilai -> Grade ${gradeOf(nilai)}")
    }
}
