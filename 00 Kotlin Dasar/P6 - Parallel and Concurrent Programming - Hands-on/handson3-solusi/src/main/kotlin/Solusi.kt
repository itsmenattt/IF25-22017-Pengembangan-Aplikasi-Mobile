import java.util.concurrent.LinkedBlockingQueue
import kotlin.concurrent.thread

// Hands-on 3: Producer-Consumer dengan BlockingQueue
// Solusi: Menggunakan LinkedBlockingQueue dengan operasi blocking put() dan take() serta sentinel value

const val PESAN_SELESAI = "SELESAI"

fun main() {
    // Membuat antrean blocking thread-safe untuk pertukaran data antar producer dan consumer
    val queue = LinkedBlockingQueue<String>()

    // Thread producer: menghasilkan 5 pesan lalu mengirimkan tanda sentinel
    val producer = thread {
        for (i in 1..5) {
            val pesan = "Pesan #$i"
            // Memasukkan pesan ke dalam antrean (blocking jika antrean penuh)
            queue.put(pesan)
            println("[Producer] mengirim: $pesan")
            // Memberikan jeda waktu 200ms sebelum pesan berikutnya
            Thread.sleep(200)
        }
        // Mengirimkan sentinel PESAN_SELESAI sebagai sinyal akhir pengiriman ke consumer
        queue.put(PESAN_SELESAI)
    }

    // Thread consumer: membaca dan memproses pesan dari antrean hingga menerima sinyal akhir
    val consumer = thread {
        while (true) {
            // Mengambil elemen dari kepala antrean (blocking / menunggu jika antrean masih kosong)
            val pesan = queue.take()

            // Jika pesan yang diterima adalah tanda sentinel, hentikan perulangan consumer
            if (pesan == PESAN_SELESAI) {
                break
            }

            // Mencetak pesan yang berhasil diterima dan diproses
            println("[Consumer] menerima: $pesan")
        }
    }

    // Menunggu thread producer dan consumer menyelesaikan tugasnya
    producer.join()
    consumer.join()
    println("Selesai!")
}
