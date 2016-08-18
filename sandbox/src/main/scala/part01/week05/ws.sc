object Lists {
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case List(e) => List()
//    case List
    case head @ List(_) :: xs => flatten(head) :: flatten(xs)
  }

  flatten(List(List(1, 1), 2, List(3, List(5, 8))))



}