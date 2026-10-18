import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

// Hands-on 2: Testing Exception

class BankAccountTest {

    @Test
    @DisplayName("Deposit menambah saldo dengan benar")
    fun testDeposit() {
        // Arrange: menyiapkan akun dengan saldo awal 100.0
        val account = BankAccount(100.0)

        // Act: melakukan deposit 50.0
        account.deposit(50.0)

        // Assert: saldo harus bertambah menjadi 150.0
        assertEquals(150.0, account.balance)
    }

    @Test
    @DisplayName("Withdraw mengurangi saldo saat saldo cukup")
    fun testWithdrawSufficientBalance() {
        // Arrange
        val account = BankAccount(100.0)

        // Act
        account.withdraw(40.0)

        // Assert
        assertEquals(60.0, account.balance)
    }

    @Test
    @DisplayName("Withdraw melempar InsufficientFundsException saat saldo tidak cukup")
    fun testWithdrawInsufficientBalance() {
        // Arrange
        val account = BankAccount(50.0)

        // Act & Assert: memastikan pemanggilan withdraw melempar exception yang sesuai
        assertThrows<InsufficientFundsException> {
            account.withdraw(100.0)
        }
    }
}
