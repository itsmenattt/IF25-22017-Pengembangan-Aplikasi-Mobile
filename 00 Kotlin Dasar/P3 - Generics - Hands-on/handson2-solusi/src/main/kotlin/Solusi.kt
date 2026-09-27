// Hands-on 2: Bounded Type Parameter
// Solusi: Menggunakan generic function dengan type constraint Comparable<T>

// Fungsi generik findMax dengan bounded type parameter T : Comparable<T>
// Memastikan tipe T yang dimasukkan dapat dibandingkan nilainya
fun <T : Comparable<T>> findMax(items: List<T>): T {
    // Memeriksa apakah list kosong; jika ya, lemparkan IllegalArgumentException
    if (items.isEmpty()) {
        throw IllegalArgumentException("List tidak boleh kosong")
    }

    // Menginisialisasi variabel max sementara dengan elemen pertama list
    var max = items[0]

    // Melakukan perulangan untuk setiap elemen di dalam list
    for (item in items) {
        // Membandingkan item dengan nilai max saat ini (menggunakan compareTo / operator >)
        if (item > max) {
            // Memperbarui nilai max jika ditemukan elemen yang lebih besar
            max = item
        }
    }

    // Mengembalikan nilai elemen terbesar yang ditemukan
    return max
}

fun main() {
    // Menguji findMax dengan list bilangan bulat (Int)
    println(findMax(listOf(3, 7, 2, 9, 4)))

    // Menguji findMax dengan list bilangan desimal (Double)
    println(findMax(listOf(1.5, 2.8, 0.3)))

    // Menguji findMax dengan list teks (String, dibandingkan secara alfabetis)
    println(findMax(listOf("apel", "jeruk", "duku")))
}
