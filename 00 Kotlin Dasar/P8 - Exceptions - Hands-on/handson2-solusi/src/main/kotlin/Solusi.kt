// Hands-on 2: Custom Exception & Exception Hierarchy

// Exception kustom yang mewarisi class Exception
class InsufficientBalanceException(message: String) : Exception(message)

class BankAccount(private val owner: String, startBalance: Double) {
    var balance: Double = startBalance
        private set

    fun deposit(amount: Double) {
        require(amount > 0) { "Jumlah deposit harus lebih besar dari 0" }
        balance += amount
    }

    fun withdraw(amount: Double) {
        require(amount > 0) { "Jumlah penarikan harus lebih besar dari 0" }

        // Memeriksa apakah saldo mencukupi sebelum ditarik
        if (amount > balance) {
            throw InsufficientBalanceException("Saldo tidak cukup! Pemilik: $owner, Saldo: $balance, Diminta: $amount")
        }

        balance -= amount
    }
}

fun main() {
    val account = BankAccount("Andi", 100_000.0)

    account.deposit(50_000.0)
    println("Saldo setelah deposit: ${account.balance}")

    // Menangani penarikan melebihi saldo dengan try-catch agar program tidak crash
    try {
        account.withdraw(500_000.0)
    } catch (e: InsufficientBalanceException) {
        println("Gagal menarik uang: ${e.message}")
    }

    account.withdraw(30_000.0)
    println("Saldo akhir: ${account.balance}")
}
