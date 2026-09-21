// Hands-on 3: Variance — declaration-site "out"
// Solusi: Menggunakan modifier "out" (covariance) karena tipe parameter hanya sebagai producer

// Kelas induk Animal
open class Animal(val name: String)

// Subclass Cat yang merupakan turunan dari Animal
class Cat(name: String) : Animal(name)

// Menambahkan modifier 'out' pada tipe parameter T (Covariant)
// Karena Container hanya memproduksi (return) nilai bertipe T dan tidak pernah mengonsumsi T sebagai parameter
interface Container<out T> {
    fun get(): T
}

// Implementasi Container khusus untuk tipe Cat
class CatContainer(private val cat: Cat) : Container<Cat> {
    override fun get(): Cat = cat
}

// Fungsi ini menerima Container<Animal>
// Berkat modifier 'out T', Container<Cat> kini valid diperlakukan sebagai subtipe dari Container<Animal>
fun printAnimalName(container: Container<Animal>) {
    println("Nama hewan: ${container.get().name}")
}

fun main() {
    // Membuat instance CatContainer yang bertipe Container<Cat>
    val catContainer: Container<Cat> = CatContainer(Cat("Whiskers"))

    // Memanggil printAnimalName dengan container Cat (berhasil karena covariance 'out')
    printAnimalName(catContainer)
}
