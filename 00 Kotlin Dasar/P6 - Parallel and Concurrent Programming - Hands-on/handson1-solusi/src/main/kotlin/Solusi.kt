import kotlin.concurrent.thread

// Hands-on 1: Race Condition
// Solusi: Mengamankan shared mutable state menggunakan blok synchronized(this)

class Counter {
    // Variabel privat untuk menyimpan nilai hitungan
    private var c = 0

    // Mengamankan fungsi increment dengan blok synchronized
    // Blok ini mengunci objek (intrinsic lock) sehingga hanya 1 thread yang bisa mengeksekusi pada saat bersamaan
    fun increment() {
        synchronized(this) {
            // Operasi increment aman dari race condition (baca-ubah-tulis terlindungi)
            c++
        }
    }

    // Membaca nilai hitungan dengan perlindungan synchronized agar membaca state terbaru secara konsisten
    fun value(): Int {
        synchronized(this) {
            return c
        }
    }
}

fun main() {
    // Membuat objek Counter bersama yang akan diakses oleh thread
    val counter = Counter()
    val iterasi = 100_000

    // Menjalankan thread 1 untuk melakukan increment sebanyak 100.000 kali
    val t1 = thread {
        repeat(iterasi) { counter.increment() }
    }

    // Menjalankan thread 2 untuk melakukan increment sebanyak 100.000 kali secara paralel
    val t2 = thread {
        repeat(iterasi) { counter.increment() }
    }

    // Menunggu thread 1 selesai sepenuhnya
    t1.join()
    // Menunggu thread 2 selesai sepenuhnya
    t2.join()

    // Menampilkan hasil akhir (dipastikan tepat bernilai 200.000)
    println("Hasil akhir: ${counter.value()} (seharusnya ${iterasi * 2})")
}
