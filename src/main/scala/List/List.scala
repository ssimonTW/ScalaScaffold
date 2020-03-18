package List

sealed trait List[+A]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

case object Nil extends List[Nothing]

object List {

  def tail[A](list: List[A]): List[A] = list match {
    case Cons(_, t) => t
  }

  def drop[A](n: Int, list: List[A]): List[A] = {
    if (n == 0) list else {
      drop(n - 1, tail(list))
    }
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  // Ex 3. Could you write sum and product of the elements of the list using foldRight?
  def sum2(ints: List[Int]): Int = ???

  def product2(ds: List[Double]): Double = ???

  // Ex 4. And the length using foldRight?
  def length : Int = ???

  def apply[A](as: A*): List[A] =
    if (as.isEmpty)
      Nil
    else
      Cons(as.head, apply(as.tail: _*))
}