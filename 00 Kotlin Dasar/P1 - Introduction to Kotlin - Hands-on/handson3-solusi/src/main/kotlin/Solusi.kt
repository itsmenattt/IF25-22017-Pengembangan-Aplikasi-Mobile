// Hands-on 3: Loops, Ranges & Null Safety
// Solusi: Menggunakan filterNotNull(), filter, sortedDescending(), dan range dengan step

class ScoreBoard(private val skorMentah: List<Int?>) {
    // Menyaring skor mentah agar hanya menyisakan nilai yang valid (bukan null)
    val skorValid: List<Int> = skorMentah.filterNotNull()

    fun skorKelulusan(batasLulus: Int): List<Int> {
        // Menyaring skor yang memenuhi ambang batas minimum dan mengurutkannya secara menurun (terbesar ke terkecil)
        return skorValid
            .filter { it >= batasLulus }
            .sortedDescending()
    }
}

fun cetakRentangGanjil(sampai: Int) {
    // Melakukan iterasi dari 1 hingga 'sampai' dengan step 2 sehingga hanya mengambil angka ganjil
    for (i in 1..sampai step 2) {
        // Mencetak angka ganjil diikuti spasi di baris yang sama
        print("$i ")
    }
    // Mencetak baris baru setelah perulangan selesai
    println()
}

fun main() {
    // Membuat objek ScoreBoard dengan beberapa data nilai, termasuk nilai null
    val papan = ScoreBoard(listOf(85, null, 72, 90, null, 55, 100))

    // Menampilkan daftar skor kelulusan yang nilainya >= 70
    println("Skor lulus (>= 70): ${papan.skorKelulusan(70)}")

    // Memanggil fungsi untuk mencetak bilangan ganjil hingga batas 10
    cetakRentangGanjil(10)
}
