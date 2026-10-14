import kotlinx.coroutines.*

// Fungsi suspend untuk mengecek status pesanan secara asynchronous
suspend fun checkOrderStatus(orderId: String): String {
    // Menunda eksekusi selama 2 detik (2000 ms) tanpa memblokir thread
    delay(2000)
    // Mengembalikan status pesanan dalam bentuk string
    return "Order $orderId: SHIPPED"
}

fun main() = runBlocking {
    // Menampilkan pesan awal sebelum memanggil fungsi suspend
    println("Menunggu status pesanan...")

    // Memanggil suspend function checkOrderStatus dari dalam runBlocking
    val status = checkOrderStatus("A100")

    // Menampilkan hasil status pesanan ke konsol
    println(status)
}
