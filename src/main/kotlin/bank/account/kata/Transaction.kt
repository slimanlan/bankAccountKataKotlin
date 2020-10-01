package bank.account.kata
data class Transaction(var payer:Account, var payee:Account, var amount:Double) {
}