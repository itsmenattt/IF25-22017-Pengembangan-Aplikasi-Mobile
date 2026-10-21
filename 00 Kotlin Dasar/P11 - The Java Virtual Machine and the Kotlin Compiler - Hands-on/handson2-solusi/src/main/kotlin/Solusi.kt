// Hands-on 2: Tailrec Optimization

fun factorialBiasa(n: Long, acc: Long = 1): Long {
    if (n <= 1) return acc
    return factorialBiasa(n - 1, acc * n)
}

// Menggunakan modifier tailrec agar compiler mengoptimasi rekursi menjadi loop pada bytecode JVM
tailrec fun factorialTailrec(n: Long, acc: Long = 1): Long {
    // Kondisi basis rekursi
    if (n <= 1) return acc
    // Pemanggilan fungsi rekursif sebagai tail call di baris terakhir
    return factorialTailrec(n - 1, acc * n)
}

fun main() {
    println("factorialBiasa(20) = ${factorialBiasa(20)}")
    println("factorialTailrec(20) = ${factorialTailrec(20)}")

    try {
        println("factorialBiasa(100000) = ${factorialBiasa(100000)}")
    } catch (e: StackOverflowError) {
        println("factorialBiasa(100000) -> StackOverflowError! (dibatasi ukuran stack JVM)")
    }

    println("factorialTailrec(100000) = ${factorialTailrec(100000)} (tidak overflow stack)")
}
