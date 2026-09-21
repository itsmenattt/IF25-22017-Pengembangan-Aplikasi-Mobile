// Hands-on 3: Closure — Counter Factory
// Solusi: Menggunakan closure di Kotlin yang menangkap (capture) dan mengingat variabel lokal

fun makeCounter(): () -> Int {
    // Mendeklarasikan variabel mutable lokal count dimulai dari 0
    // Variabel ini akan "ditangkap" (captured) dan tetap hidup di dalam memori selama closure aktif
    var count = 0

    // Mengembalikan fungsi anonim / lambda () -> Int
    return {
        // Menambahkan nilai count sebesar 1 setiap kali fungsi ini dieksekusi
        count += 1
        // Mengembalikan nilai count yang telah diperbarui
        count
    }
}

fun main() {
    // Membuat dua instance counter independen
    val counterA = makeCounter()
    val counterB = makeCounter()

    // Memanggil counterA berulang kali; nilainya bertambah secara mandiri
    println(counterA())
    println(counterA())
    println(counterA())

    // Memanggil counterB; state count-nya terpisah dan tidak terpengaruh oleh counterA
    println(counterB())
    println(counterB())
}
