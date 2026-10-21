// Hands-on 1: Inline Function & Reified Generics

// Fungsi inline dengan type parameter reified agar tipe T tidak dihapus (type erasure) saat runtime
inline fun <reified T> isType(value: Any): Boolean {
    // Mengecek apakah objek value merupakan instance dari tipe T
    return value is T
}

fun main() {
    println(isType<String>("Hello"))
    println(isType<Int>("Hello"))
    println(isType<String>(123))

    // Jawaban diskusi:
    // Pada JVM biasa, generics mengalami Type Erasure, artinya informasi tipe generik <T>
    // dihapus saat dikompilasi ke bytecode sehingga saat runtime JVM tidak tahu tipe aslinya.
    // Oleh karena itu, ekspresi `value is T` tidak bisa dikompilasi secara generik biasa.
    // Dengan modifier `inline` + `reified`, compiler Kotlin menduplikasi isi fungsi langsung
    // ke tempat pemanggilannya dengan menyertakan tipe konkretnya (misal String atau Int),
    // sehingga pengecekan tipe pada saat runtime dapat berhasil dilakukan.
}
