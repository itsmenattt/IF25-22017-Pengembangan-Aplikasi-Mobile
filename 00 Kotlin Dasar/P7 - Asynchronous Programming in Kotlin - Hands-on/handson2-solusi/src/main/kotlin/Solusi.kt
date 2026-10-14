import kotlinx.coroutines.*

// Fungsi suspend untuk mencatat log akses (tidak mengembalikan nilai balik)
suspend fun writeAccessLog(message: String) {
    // Menunda eksekusi selama 500 ms untuk simulasi penulisan log
    delay(500)
    // Menampilkan pesan log ke konsol
    println("[LOG] $message")
}

// Fungsi suspend untuk menghitung total harga belanjaan (mengembalikan nilai Int)
suspend fun calculateTotalPrice(prices: List<Int>): Int {
    // Menunda eksekusi selama 700 ms untuk simulasi perhitungan
    delay(700)
    // Mengembalikan jumlah total dari seluruh daftar harga
    return prices.sum()
}

fun main() = runBlocking {
    // Daftar harga barang yang akan dihitung
    val prices = listOf(15000, 25000, 10000)

    // Menjalankan writeAccessLog dengan launch karena tidak memerlukan nilai kembalian
    launch {
        writeAccessLog("Checkout dimulai")
    }

    // Menjalankan calculateTotalPrice dengan async untuk mendapatkan hasil secara asynchronous
    val deferredTotal = async {
        calculateTotalPrice(prices)
    }

    // Mengambil nilai hasil dari async menggunakan await()
    val total = deferredTotal.await()

    // Menampilkan hasil total belanja ke konsol
    println("Total belanja: Rp$total")
}
