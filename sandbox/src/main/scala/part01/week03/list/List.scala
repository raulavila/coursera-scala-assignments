package part01.week03.list

trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
  //head and tail already implemented with val parameters
}

class Nil[T] extends List[T] {
  def isEmpty: Boolean = true
  def head: Nothing =  throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}