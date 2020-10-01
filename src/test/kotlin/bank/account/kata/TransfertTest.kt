package bank.account.kata

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach

class TransfertTest {
  
  var payer:Account = Account()
  var payee:Account = Account()
  var transfert:Transfert = Transfert(payer, payee);
	
  @BeforeEach
  fun setup() {
    payer.deposit(500.00)
  }
	
  @Test
  fun test_transfert_payer_amount() {
    transfert.transfertAmountFromPayerToPayee(60.00)
    Assertions.assertEquals(payer.amount, 440.00)
  }
	
  @Test
  fun test_transfert_payee_amount() {
    transfert.transfertAmountFromPayerToPayee(60.00)
    Assertions.assertEquals(payee.amount, 60.00)
  }
	
  @Test
  fun test_multipe_transfert_from_payer() {
    transfert.transfertAmountFromPayerToPayee(60.00)
    transfert.transfertAmountFromPayerToPayee(30.00)
    Assertions.assertEquals(payer.amount, 410.00)
  }
	
  @Test
  fun test_multipe_transfert_to_payee() {
    transfert.transfertAmountFromPayerToPayee(100.00)
    transfert.transfertAmountFromPayerToPayee(40.00)
    Assertions.assertEquals(payee.amount, 140.00)
  }
}