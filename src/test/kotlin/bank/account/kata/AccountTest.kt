package bank.account.kata

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

class AccountTest {
  
  var account:Account = Account()
 
  @BeforeEach
  fun setup() {
    account.deposit(100.00)
  }
	
  @Test
  fun test_deposit_amount() {
    Assertions.assertEquals(account.amount, 100.00)
  }
	
  @Test
  fun test_withdraw_amount() {
    account.withdraw(50.00)
    Assertions.assertEquals(account.amount, 50.00)
  }
	
  @Test
  fun test_multipe_withdraw_amount() {
    account.withdraw(50.00)
    account.withdraw(20.00)
    Assertions.assertEquals(account.amount, 30.00)
  }
	
}