package bank.account.kata

class TransactionRecord {
  
  val TransactionRecord = ArrayList<Transaction>();
 
  fun saveTransaction(payer:Account, payee:Account, amount:Double):Transaction {
    val transfert = Transfert(payer, payee)
    transfert.transfertAmountFromPayerToPayee(amount)
    val transaction = Transaction(payer, payee, amount)
    TransactionRecord.add(transaction)
    return transaction
  }
  
  fun getAllTransactionFromPayer(payer:Account):List<Transaction> {
    return TransactionRecord.filter { transaction-> transaction.payer.equals(payer) } 
  }
  
  fun getAllTransactionToPayee(payee:Account):List<Transaction> {
     return TransactionRecord.filter { transaction-> transaction.payee.equals(payee) } 
  }
	
}