import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress

// Hands-on 3: Request Handling & Status Code

fun main() {
    val server = HttpServer.create(InetSocketAddress("0.0.0.0", 8080), 0)

    // Handler untuk endpoint POST /echo
    server.createContext("/echo") { exchange ->
        // Jika method bukan POST, kembalikan status 405 Method Not Allowed
        if (exchange.requestMethod != "POST") {
            exchange.sendResponseHeaders(405, -1)
            exchange.close()
            return@createContext
        }

        // Membaca seluruh byte data dari request body
        val requestBytes = exchange.requestBody.readBytes()

        // Mengirimkan kembali byte request sebagai response dengan status 200 OK
        exchange.sendResponseHeaders(200, requestBytes.size.toLong())
        exchange.responseBody.use { outputStream ->
            outputStream.write(requestBytes)
        }
    }

    // Handler default untuk menangani path yang tidak terdaftar (404 Not Found)
    server.createContext("/") { exchange ->
        val path = exchange.requestURI.path
        val responseText = "Not Found: $path"
        val responseBytes = responseText.toByteArray(Charsets.UTF_8)

        exchange.sendResponseHeaders(404, responseBytes.size.toLong())
        exchange.responseBody.use { outputStream ->
            outputStream.write(responseBytes)
        }
    }

    server.start()
    println("Server berjalan di http://localhost:8080")
    println("Coba: curl -X POST -d 'halo dunia' http://localhost:8080/echo")
    println("Coba: curl -i http://localhost:8080/tidak-ada")

    Thread.sleep(10_000)
    server.stop(0)
    println("Server dihentikan")
}
