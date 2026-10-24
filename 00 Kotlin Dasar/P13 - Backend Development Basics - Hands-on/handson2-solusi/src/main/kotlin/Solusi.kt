import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

// Hands-on 2: Routing & JSON Sederhana

data class User(val id: Int, val name: String)

val users = listOf(
    User(1, "Andi"),
    User(2, "Budi"),
    User(3, "Citra")
)

// Mengubah daftar User menjadi string JSON array secara manual
fun usersToJson(users: List<User>): String {
    val items = users.map { "{\"id\":${it.id},\"name\":\"${it.name}\"}" }
    return "[${items.joinToString(",")}]"
}

fun main() {
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)

    // Mendaftarkan endpoint /users yang mengembalikan data JSON
    server.createContext("/users") { exchange ->
        val jsonString = usersToJson(users)
        val responseBytes = jsonString.toByteArray(Charsets.UTF_8)

        // Menetapkan header Content-Type sebelum memanggil sendResponseHeaders
        exchange.responseHeaders.set("Content-Type", "application/json")
        exchange.sendResponseHeaders(200, responseBytes.size.toLong())

        // Mengirimkan response body ke client
        exchange.responseBody.use { outputStream ->
            outputStream.write(responseBytes)
        }
    }

    server.start()
    println("Server berjalan di http://localhost:8080 — coba: curl http://localhost:8080/users")

    Thread.sleep(10_000)
    server.stop(0)
    println("Server dihentikan")
}
