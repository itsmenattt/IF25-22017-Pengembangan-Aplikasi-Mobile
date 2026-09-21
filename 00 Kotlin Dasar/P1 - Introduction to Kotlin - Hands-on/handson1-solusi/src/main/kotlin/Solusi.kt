// Hands-on 1: Variabel, Fungsi & String Template
// Solusi: Menggunakan safe call (?.) dan elvis operator (?:) serta string template

fun describeProfile(nama: String, umur: Int?, kota: String = "Tidak diketahui"): String {
    // Menangani variabel umur yang bersifat nullable (Int?)
    // Menggunakan safe call (?.) dengan fungsi .let agar jika umur tidak null, formatnya menjadi "$it tahun"
    // Menggunakan elvis operator (?:) untuk memberikan nilai default "umur tidak diketahui" jika umur bernilai null
    val umurText = umur?.let { "$it tahun" } ?: "umur tidak diketahui"

    // Mengembalikan teks profil yang rapi sesuai format menggunakan string template ($nama, $umurText, $kota)
    return "Nama: $nama, Umur: $umurText, Kota: $kota"
}

fun main() {
    // Memanggil fungsi describeProfile dengan parameter lengkap (nama, umur, kota)
    println(describeProfile("Andi", 20, "Bandar Lampung"))

    // Memanggil fungsi dengan umur bernilai null untuk menguji elvis operator, dan kota menggunakan default parameter
    println(describeProfile("Budi", null))

    // Memanggil fungsi menggunakan named argument (nama dan umur), kota otomatis menggunakan default parameter
    println(describeProfile(nama = "Citra", umur = 19))
}
