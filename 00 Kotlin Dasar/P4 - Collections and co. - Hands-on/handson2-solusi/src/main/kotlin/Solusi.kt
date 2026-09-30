// Hands-on 2: Grouping & Aggregation
// Solusi: Menggunakan groupBy, mapValues, sumOf, dan associateBy pada collection

data class Transaksi(val id: String, val kategori: String, val nominal: Int)

fun totalPerKategori(transaksi: List<Transaksi>): Map<String, Int> {
    // Mengelompokkan transaksi dan menghitung total nominal tiap kategori
    return transaksi
        // 1. Mengelompokkan list transaksi berdasarkan nama kategori (menghasilkan Map<String, List<Transaksi>>)
        .groupBy { it.kategori }
        // 2. Mentransformasikan nilai (value) dari setiap grup dengan menjumlahkan seluruh nominal transaksi di dalamnya
        .mapValues { (_, daftarTransaksi) -> daftarTransaksi.sumOf { it.nominal } }
}

fun transaksiById(transaksi: List<Transaksi>): Map<String, Transaksi> {
    // Mengubah list transaksi menjadi Map dengan ID transaksi sebagai key pencarian unik
    return transaksi.associateBy { it.id }
}

fun main() {
    // Daftar riwayat transaksi pengeluaran
    val transaksi = listOf(
        Transaksi("TRX01", "Makanan", 50_000),
        Transaksi("TRX02", "Transportasi", 20_000),
        Transaksi("TRX03", "Makanan", 35_000),
        Transaksi("TRX04", "Hiburan", 100_000),
        Transaksi("TRX05", "Transportasi", 15_000)
    )

    // Menampilkan hasil agregasi total pengeluaran per kategori
    println("Total per kategori: ${totalPerKategori(transaksi)}")

    // Melakukan pencarian transaksi cepat berdasarkan ID menggunakan Map
    val byId = transaksiById(transaksi)
    println("Cari TRX03: ${byId["TRX03"]}")
}
