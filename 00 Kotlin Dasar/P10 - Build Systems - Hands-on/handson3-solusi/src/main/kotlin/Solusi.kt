import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

// Hands-on 3: Dependency Declaration

fun main() {
    // Mengambil timestamp saat ini
    val now = Clock.System.now()
    // Mengonversi waktu saat ini ke tanggal lokal sistem
    val today = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
    println("Hari ini: $today")
}
