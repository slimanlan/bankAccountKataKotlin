package bank.account.kata

class Transfert(var payer:Account, var payee:Account) {

  fun transfertAmountFromPayerToPayee(amount:Double) {
    payer.withdraw(amount)
    payee.deposit(amount)
  }
	
}