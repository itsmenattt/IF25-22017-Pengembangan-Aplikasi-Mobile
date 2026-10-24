import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

// Hands-on 1: HTTP Server Sederhana

fun main() {
    // Membuat instance HttpServer yang listen pada semua interface (0.0.0.0) di port 8080
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)

    // Mendaftarkan context handler untuk path "/hello"
    server.createContext("/hello") { exchange ->
        val responseText = "Hello, Kotlin Backend!"
        val responseBytes = responseText.toByteArray(Charsets.UTF_8)

        // Mengirimkan status HTTP 200 OK beserta panjang konten dalam byte
        exchange.sendResponseHeaders(200, responseBytes.size.toLong())

        // Menuliskan response body ke stream dan menutupnya
        exchange.responseBody.use { outputStream ->
            outputStream.write(responseBytes)
        }
    }

    // Menjalankan server HTTP
    server.start()
    println("Server berjalan di http://localhost:8080/hello — coba: curl http://localhost:8080/hello")

    // Menjalankan server selama 10 detik lalu berhenti secara otomatis
    Thread.sleep(10_000)
    server.stop(0)
    println("Server dihentikan")
}
