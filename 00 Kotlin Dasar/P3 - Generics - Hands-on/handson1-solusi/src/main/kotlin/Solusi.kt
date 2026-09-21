// Hands-on 1: Generic Class — Box<T>
// Solusi: Menggunakan generic class dengan generic function map<R>

// Generic class Box yang menyimpan nilai bertipe T
class Box<T>(val value: T) {
    // Fungsi generik map untuk mentransformasikan nilai di dalam Box ke tipe baru R
    // tanpa mengubah objek Box yang lama (immutable)
    fun <R> map(transform: (T) -> R): Box<R> {
        // Menerapkan fungsi transform pada nilai lama, lalu membungkus hasilnya ke dalam Box baru
        return Box(transform(value))
    }
}

fun main() {
    // Membuat instance Box bertipe Int
    val intBox = Box(23)
    println("intBox.value = ${intBox.value}")

    // Membuat instance Box bertipe String (tipe parameter di-infer secara otomatis)
    val cupBox = Box("cup")
    println("cupBox.value = ${cupBox.value}")

    // Mentransformasikan Box<Int> menjadi Box<String> menggunakan fungsi map
    val stringBox = intBox.map { "Angka: $it" }
    println("stringBox.value = ${stringBox.value}")

    // Mentransformasikan Box<String> menjadi Box<Int> berisi panjang karakter string
    val lengthBox = cupBox.map { it.length }
    println("lengthBox.value = ${lengthBox.value}")
}
