package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(r == 0 && c == 0) 1
    else if(c < 0 || c > r) 0
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def balanceIter(chars: List[Char], stack: List[Char]): Boolean = {
      if(chars.isEmpty && stack.isEmpty) true
      else if(chars.isEmpty && stack.nonEmpty) false
      else if(chars.head == '(') balanceIter(chars.tail, stack:+'(' )
      else if(chars.head == ')' && stack.nonEmpty && stack.last == '(') balanceIter(chars.tail, stack.init)
      else if(chars.head == ')' && (stack.isEmpty || stack.last != '(')) false
      else balanceIter(chars.tail, stack)
    }

    balanceIter(chars, List[Char]())
  }
  
  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def noMoneyButCoinsLeft(money: Int, coins: List[Int]): Boolean = {
      money == 0 && coins.nonEmpty
    }

    def canChangeSomething(money: Int, coins: List[Int]): Boolean = {
      if(money == 0)
        false
      else if(coins.isEmpty)
        false
      else
        anyCoinValid(money, coins)
    }

    def anyCoinValid(money: Int, coins: List[Int]): Boolean = {
      if(coins.isEmpty)
        false
      else
        isChangePossible(money, coins.head) || anyCoinValid(money, coins.tail)
    }

    def isChangePossible(money: Int, coin: Int): Boolean = {
      money - coin >= 0
    }

    if(noMoneyButCoinsLeft(money, coins))
      1
    else if(!canChangeSomething(money, coins))
      0
    else if(isChangePossible(money, coins.head)) {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
    else
      countChange(money, coins.tail)

  }
}
