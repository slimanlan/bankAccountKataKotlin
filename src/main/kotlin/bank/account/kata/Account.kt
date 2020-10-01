package bank.account.kata

class Account {
	
  var amount = 0.0
  
  fun deposit(amount:Double) {
    this.amount += amount
  }

  fun withdraw(amount:Double) {
    this.amount -= amount
  }
	
}