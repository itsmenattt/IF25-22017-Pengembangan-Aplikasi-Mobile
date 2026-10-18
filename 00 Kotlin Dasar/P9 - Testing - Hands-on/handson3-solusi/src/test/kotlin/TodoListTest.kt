import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

// Hands-on 3: Test Lifecycle & Setup dengan @BeforeEach

class TodoListTest {

    private lateinit var todoList: TodoList

    @BeforeEach
    fun setUp() {
        // Menginisialisasi instance TodoList baru sebelum setiap test dijalankan
        todoList = TodoList()
    }

    @Test
    @DisplayName("TodoList baru harus kosong")
    fun testNewListIsEmpty() {
        assertTrue(todoList.isEmpty())
    }

    @Test
    @DisplayName("Menambah item menaikkan ukuran list")
    fun testAddIncreasesSize() {
        // Act: menambahkan satu item baru
        todoList.add("Belajar Kotlin")

        // Assert: memastikan jumlah item sekarang menjadi 1
        assertEquals(1, todoList.size())
    }

    @Test
    @DisplayName("Menghapus item mengembalikan true dan mengurangi ukuran")
    fun testRemoveExistingItem() {
        // Arrange: menyiapkan list yang berisi item
        todoList.add("Belajar Kotlin")

        // Act: menghapus item yang ada
        val removed = todoList.remove("Belajar Kotlin")

        // Assert: memastikan penghapusan berhasil dan ukuran list kembali 0
        assertTrue(removed)
        assertEquals(0, todoList.size())
    }
}
