package bank.account.kata

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach


class TransactionRecordTest {
  
  var transactionRecord:TransactionRecord = TransactionRecord()
  var payer:Account =  Account()
  var payee:Account =  Account()
	
  @BeforeEach
  fun setup() {
    payer.deposit(1000.00)
  }
	
  @Test
  fun test_save_transaction_payer_amount() {
    val transaction = transactionRecord.saveTransaction(payer, payee, 50.00)
    Assertions.assertEquals(transaction.payer.amount, 950.00)
  }
	
  @Test
  fun test_save_transaction_payee_amount() {
    val transaction = transactionRecord.saveTransaction(payer, payee, 50.00)
    Assertions.assertEquals(transaction.payee.amount, 50.00)
  }
	
  @Test
  fun test_save_transaction_amount() {
    val transaction = transactionRecord.saveTransaction(payer, payee, 50.00)
    Assertions.assertEquals(transaction.amount, 50.00)
  }
	
  @Test
  fun test_save_transaction_from_payer_to_payee() {
    val transaction = transactionRecord.saveTransaction(payer, payee, 50.00)
    Assertions.assertEquals(transaction.payer, payer)
    Assertions.assertEquals(transaction.payee, payee)
  }
	
  @Test
  fun test_get_all_transaction_from_payer() {
    transactionRecord.saveTransaction(payer, payee, 50.00)
    transactionRecord.saveTransaction(payer, payee, 150.00)
    transactionRecord.saveTransaction(payer, payee, 250.00)
    val transactionRecordFromPayer = transactionRecord.getAllTransactionFromPayer(payer)
    Assertions.assertEquals(transactionRecordFromPayer.size, 3)
    transactionRecordFromPayer.forEach({ transaction-> Assertions.assertEquals(transaction.payer, payer) })
  }
	
  @Test
  fun test_get_all_transaction_to_payee() {
    transactionRecord.saveTransaction(payer, payee, 100.00)
    transactionRecord.saveTransaction(payer, payee, 50.00)
    transactionRecord.saveTransaction(payer, payee, 120.00)
    transactionRecord.saveTransaction(payer, payee, 130.00)
    val transactionRecordToPayee = transactionRecord.getAllTransactionToPayee(payee)
    Assertions.assertEquals(transactionRecordToPayee.size, 4)
    transactionRecordToPayee.forEach({ transaction-> Assertions.assertEquals(transaction.payee, payee) })
  }
}