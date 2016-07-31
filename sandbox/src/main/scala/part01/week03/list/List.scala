package part01.week03.list

trait List[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  //head and tail already implemented with val parameters
}

object Nil extends List[Nothing] {
  def isEmpty: Boolean = true
  def head: Nothing =  throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object test {
  val x: List[String] = Nil
}

//object List {
//  //List(1,2) = List.apply(1,2)
//  def apply[T](x1: T, x2: T): List[T] =  new Cons(x1, new Cons(x2, Nil))
//  def apply[T]() = Nil
//}