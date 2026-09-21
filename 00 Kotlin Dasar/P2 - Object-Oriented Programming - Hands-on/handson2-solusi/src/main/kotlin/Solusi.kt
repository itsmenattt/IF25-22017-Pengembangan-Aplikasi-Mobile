// Hands-on 2: Interface & Data Class
// Solusi: Menggunakan interface, data class, fungsi copy(), dan perbandingan struktural equals (==)

// Interface Payable yang mendefinisikan kontrak fungsi hitung gaji tanpa menyimpan state
interface Payable {
    // Fungsi abstrak yang harus diimplementasikan oleh kelas turunannya
    fun calculateSalary(): Double
}

// Data class Employee yang mengimplementasikan interface Payable
// Data class otomatis menyediakan fungsi equals(), hashCode(), toString(), dan copy()
data class Employee(val name: String, val baseSalary: Double, val bonus: Double) : Payable {

    // Mengimplementasikan fungsi hitung gaji total dengan menjumlahkan gaji pokok dan bonus
    override fun calculateSalary(): Double {
        return baseSalary + bonus
    }
}

fun main() {
    // Membuat objek Employee awal dengan data Alice
    val alice = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)

    // Menggunakan fitur copy() untuk menduplikasi objek alice dan hanya mengubah properti name menjadi Bob
    val bob = alice.copy(name = "Bob")

    // Menampilkan total gaji dari masing-masing objek
    println("Gaji ${alice.name}: ${alice.calculateSalary()}")
    println("Gaji ${bob.name}: ${bob.calculateSalary()}")

    // Membuat instance baru yang memiliki nilai properti identik dengan alice
    val aliceDuplicate = Employee("Alice", baseSalary = 5_000_000.0, bonus = 500_000.0)

    // Membandingkan kesamaan isi antar dua objek menggunakan operator == (memanggil equals bawaan data class)
    println("alice == aliceDuplicate? ${alice == aliceDuplicate}")

    // Menampilkan representasi String dari objek alice (memanfaatkan fungsi toString() bawaan data class)
    println(alice)
}
