import java.util.concurrent.Callable
import java.util.concurrent.Executors

// Hands-on 2: ExecutorService & Future
// Solusi: Menjalankan task lambat secara paralel menggunakan ExecutorService fixed thread pool

fun hitungKuadrat(n: Int): Int {
    // Simulasi pekerjaan berat dengan menunda eksekusi selama 1 detik (1000ms)
    Thread.sleep(1000)
    // Mengembalikan hasil kuadrat dari bilangan n
    return n * n
}

fun main() {
    // Daftar angka input yang akan diproses
    val angka = listOf(1, 2, 3, 4)
    // Mencatat waktu mulai eksekusi dalam milidetik
    val startTime = System.currentTimeMillis()

    // Membuat thread pool dengan 4 thread pekerja aktif
    val executor = Executors.newFixedThreadPool(4)

    // Mengirimkan (submit) setiap tugas perhitungan ke thread pool sebagai Callable
    // Hasil kembalian berupa daftar objek Future yang memegang hasil asinkron
    val futures = angka.map { n ->
        executor.submit(Callable { hitungKuadrat(n) })
    }

    // Mengambil nilai hasil komputasi dari setiap Future menggunakan fungsi get() (blocking hingga task selesai)
    val hasil = futures.map { it.get() }
    // Menampilkan hasil perhitungan kuadrat
    println("Hasil: $hasil")

    // Menutup executor service agar thread pool berhenti dan JVM dapat keluar dengan bersih
    executor.shutdown()

    // Mencatat waktu selesai dan menghitung total durasi eksekusi
    val endTime = System.currentTimeMillis()
    // Karena dijalankan secara paralel oleh 4 thread, total durasi eksekusi berkisar ~1000ms (bukan ~4000ms)
    println("Waktu: ${endTime - startTime}ms")
}
