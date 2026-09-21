// Hands-on 1: Transformasi Collection
// Solusi: Menggunakan chaining fungsi collection filter, sortedBy, dan map

data class Product(val nama: String, val harga: Int, val stok: Int)

fun produkDiAtasHarga(produk: List<Product>, minHarga: Int): List<String> {
    // Melakukan pipeline transformasi pada collection produk
    return produk
        // 1. Menyaring produk yang memiliki harga lebih besar dari ambang batas minHarga
        .filter { it.harga > minHarga }
        // 2. Mengurutkan produk hasil saringan dari harga terendah ke tertinggi
        .sortedBy { it.harga }
        // 3. Mengambil properti nama saja sehingga menghasilkan List<String>
        .map { it.nama }
}

fun main() {
    // Daftar produk dalam katalog
    val katalog = listOf(
        Product("Mouse Wireless", 75_000, 20),
        Product("Keyboard Mechanical", 450_000, 5),
        Product("Monitor 24 inch", 1_500_000, 3),
        Product("USB Flashdisk 32GB", 60_000, 50),
        Product("Webcam HD", 250_000, 8)
    )

    // Memanggil fungsi untuk mencari produk dengan harga di atas 100.000
    val hasil = produkDiAtasHarga(katalog, 100_000)
    println("Produk dengan harga di atas Rp100.000 (termurah dulu):")
    println(hasil)
}
