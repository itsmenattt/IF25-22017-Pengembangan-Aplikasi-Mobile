import kotlinx.coroutines.*

// Kelas untuk mengelola unduhan file menggunakan CoroutineScope
class DownloadManager(private val scope: CoroutineScope) {

    // Fungsi untuk menjalankan unduhan file sebagai coroutine anak (child coroutine)
    fun downloadFile(name: String, durationMs: Long): Job {
        // Meluncurkan coroutine baru di dalam scope yang telah disediakan
        val job = scope.launch {
            // Simulasi waktu proses pengunduhan file
            delay(durationMs)
            // Menampilkan informasi bahwa file telah berhasil diunduh
            println("$name selesai di-download")
        }
        // Mengembalikan objek Job untuk memantau atau mengontrol status coroutine
        return job
    }
}

fun main() = runBlocking {
    // Membuat Job induk (parent job) untuk mengontrol seluruh coroutine anak
    val parentJob = Job()

    // Membuat CoroutineScope baru yang terhubung dengan parentJob
    val scope = CoroutineScope(parentJob)

    // Membuat objek DownloadManager menggunakan scope yang telah disiapkan
    val manager = DownloadManager(scope)

    // Menjalankan simulasi unduhan beberapa file dengan durasi berbeda
    manager.downloadFile("foto.jpg", 1000)
    manager.downloadFile("video.mp4", 3000)
    manager.downloadFile("dokumen.pdf", 1500)

    // Memberi jeda waktu agar file dengan durasi singkat sempat selesai
    delay(1200)

    // Memberitahukan bahwa proses pembatalan unduhan dimulai
    println("Membatalkan sisa download...")
    // Membatalkan parentJob, yang secara otomatis membatalkan seluruh coroutine anak yang belum selesai
    parentJob.cancel()

    // Menunggu untuk membuktikan bahwa coroutine yang dibatalkan tidak lagi berjalan
    delay(2000)
    // Menandai akhir dari eksekusi program utama
    println("Selesai.")
}
