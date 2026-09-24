// Hands-on 1: Class & Inheritance
// Solusi: Menggunakan open class, primary constructor, inheritance, dan override fungsi

// Base class (kelas induk) yang ditandai open agar dapat diwarisi oleh kelas lain
open class Vehicle(val name: String, val maxSpeed: Int) {

    // Fungsi pada kelas induk yang ditandai open agar dapat di-override oleh kelas turunan
    open fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h"
    }
}

// Kelas Car mewarisi kelas Vehicle dan mempassing name serta maxSpeed tetap = 180 ke constructor induk
class Car(name: String, val numberOfDoors: Int) : Vehicle(name, maxSpeed = 180) {
    // Meng-override fungsi describe untuk menambahkan informasi jumlah pintu mobil
    override fun describe(): String {
        return "$name dapat melaju hingga $maxSpeed km/h dan punya $numberOfDoors pintu"
    }
}

// Kelas Motorcycle mewarisi kelas Vehicle dan mempassing name serta maxSpeed tetap = 220 ke constructor induk
class Motorcycle(name: String, val hasSidecar: Boolean) : Vehicle(name, maxSpeed = 220) {
    // Meng-override fungsi describe untuk menambahkan informasi keberadaan sespan (sidecar)
    override fun describe(): String {
        // Menentukan teks keterangan apakah motor menggunakan sidecar atau tidak
        val sidecarText = if (hasSidecar) "dengan sidecar" else "tanpa sidecar"
        return "$name dapat melaju hingga $maxSpeed km/h ($sidecarText)"
    }
}

fun main() {
    // Membuat list bertipe dasar Vehicle yang berisi instance dari subclass Car dan Motorcycle
    val vehicles = listOf<Vehicle>(
        Car("Toyota", numberOfDoors = 4),
        Motorcycle("Ninja", hasSidecar = false)
    )

    // Memanggil describe() secara polimorfik untuk setiap kendaraan dalam list
    vehicles.forEach { println(it.describe()) }
}
