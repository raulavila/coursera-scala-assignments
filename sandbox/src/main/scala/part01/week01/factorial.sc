object factorial {
  def factorial(n: Int): Int = {
    def factorialIter(n: Int, acc: Int): Int = {
      if(n == 0) acc else factorialIter(n -1, n * acc)
    }
    factorialIter(n, 1)
  }

  factorial(3)
}