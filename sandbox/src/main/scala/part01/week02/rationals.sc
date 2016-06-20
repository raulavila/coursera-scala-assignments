object rationals {
  class Rational(x: Int, y: Int) {
    require(y != 0, "denominator must be non zero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = {
      if(b == 0) a
      else gcd(b, a % b)
    }

    //val, so we don't have to recalculate...
    private val g = gcd(x,y)

    //We should simplify rationals here instead of toString
    //because this way it's less risky to produce arithmetic overflows
    //when adding rationals
    def numer = x / g
    def denom = y / g

    def < (that: Rational) = {
      numer * that.denom < that.numer * denom
    }

    def max(that: Rational) = {
      if(this < that) that
      else this
    }

    def + (that: Rational) = {
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    def unary_- : Rational = new Rational(-numer, denom)

    def - (that: Rational) = this + -that

    override def toString() = numer + "/" + denom
  }

  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  val strange = new Rational(1, 0)
}

