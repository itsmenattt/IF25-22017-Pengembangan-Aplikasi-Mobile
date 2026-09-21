// Hands-on 3: Sealed Class untuk State
// Solusi: Menggunakan sealed class untuk merepresentasikan state terbatas dan when exhaustive

// Sealed class NetworkResult yang membatasi hierarki state hanya pada file ini
sealed class NetworkResult

// Object Loading merepresentasikan state memuat data (singleton tanpa membawa data tambahan)
object Loading : NetworkResult()

// Data class Success merepresentasikan state berhasil dan membawa nilai data hasil respon
data class Success(val data: String) : NetworkResult()

// Data class Error merepresentasikan state gagal dan membawa pesan error
data class Error(val message: String) : NetworkResult()

// Fungsi describe untuk mendeskripsikan state dari NetworkResult
fun describe(result: NetworkResult): String {
    // Menggunakan when expression exhaustive (kompiler memeriksa semua kemungkinan subclass tanpa butuh else)
    return when (result) {
        // Menangani state Loading
        is Loading -> "Sedang memuat..."
        // Menangani state Success dan membaca properti data di dalamnya
        is Success -> "Berhasil: ${result.data}"
        // Menangani state Error dan membaca properti message di dalamnya
        is Error -> "Gagal: ${result.message}"
    }
}

fun main() {
    // Menguji pemanggilan fungsi describe untuk masing-masing state
    println(describe(Loading))
    println(describe(Success("Data pengguna berhasil diambil")))
    println(describe(Error("Koneksi terputus")))
}
