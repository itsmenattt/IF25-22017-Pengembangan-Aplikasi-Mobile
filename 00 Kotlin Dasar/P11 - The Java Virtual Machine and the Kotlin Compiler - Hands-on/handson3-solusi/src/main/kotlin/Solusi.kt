// Hands-on 3: companion object & @JvmStatic

class Greeter {
    companion object {
        // Anotasi @JvmStatic menghasilkan static method sungguhan pada kelas Greeter di level JVM bytecode
        @JvmStatic
        fun greet(name: String): String {
            return "Halo, $name!"
        }
    }
}

fun main() {
    println(Greeter.greet("Mahasiswa"))

    // Mengambil daftar method yang ada pada kelas Greeter secara reflection Java
    val staticMethodNames = Greeter::class.java.methods.map { it.name }
    println("Method pada Greeter.class: $staticMethodNames")

    // Memverifikasi apakah method static "greet" berhasil ditemukan di kelas Greeter
    val punyaStaticGreet = staticMethodNames.contains("greet")
    println("Greeter.class punya static method 'greet'? $punyaStaticGreet")

    check(punyaStaticGreet) {
        "greet() belum jadi static method di Greeter.class — tambahkan @JvmStatic!"
    }
}
