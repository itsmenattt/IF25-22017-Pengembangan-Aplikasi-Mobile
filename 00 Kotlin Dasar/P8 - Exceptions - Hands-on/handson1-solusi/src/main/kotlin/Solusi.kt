// Hands-on 1: Try-Catch-Finally Dasar

fun safeDivide(a: Int, b: Int): Int {
    try {
        // Melakukan pembagian bilangan bulat
        return a / b
    } catch (e: ArithmeticException) {
        // Menangani pembagian dengan nol agar tidak crash
        println("Error: Tidak bisa membagi dengan nol (${e.message})")
        return 0
    } finally {
        // Blok finally selalu dijalankan baik proses sukses maupun terjadi exception
        println("safeDivide($a, $b) selesai diproses")
    }
}

fun main() {
    println("Hasil 1: ${safeDivide(10, 2)}")
    println("Hasil 2: ${safeDivide(10, 0)}")
    println("Hasil 3: ${safeDivide(9, 3)}")
}
