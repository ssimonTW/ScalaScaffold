package Option

trait OptionTrait[+A] {
  def map[B](f: A => B): OptionTrait[B]

  def flatMap[B](f: A => OptionTrait[B]): OptionTrait[B]

  def getOrElse[B >: A](default: => B): B

  def orElse[B >: A](ob: => OptionTrait[B]): OptionTrait[B]

  def filter(f: A => Boolean): OptionTrait[A]
}

//Ex. 7:
//  Let’s implement all of the functions on Option. As you implement each function,
//  try to think about what it means and in what situations you’d use it. We’ll explore when to use each of these functions next.

//  Here are a few hints for solving this exercise:
//  Use pattern matching, though you should be able to implement all the functions besides map and getOrElse without resorting to pattern matching.
//  For map and flatMap, the type signature should be enough to determine the implementation.
//  getOrElse returns the result inside the Some case of the Option, or if the Option is None, returns the given default value.
//  orElse returns the first Option if it’s defined; otherwise, it returns the second Option.

case class MyOption[+A](value: A) extends OptionTrait[A] {
  override def map[B](f: A => B): OptionTrait[B] = ???

  override def flatMap[B](f: A => OptionTrait[B]): OptionTrait[B] = ???

  override def getOrElse[B >: A](default: => B): B = ???

  override def orElse[B >: A](ob: => OptionTrait[B]): OptionTrait[B] = ???

  override def filter(f: A => Boolean): OptionTrait[A] = ???

// Ex.8 Write a generic function map2 that combines two Option values using a binary function.
  def map2[A, B, C](a: scala.Option[A], b: scala.Option[B])(f: (A, B) => C): scala.Option[C] = ???

//  Ex. 9:
//  Write a function sequence that combines a list of Options into one Option containing a list of all the Some values in the original list.
  //  If the original list contains None even once, the result of the function should be None; otherwise the result should be Some with a list of all the values.
  //  Here is its signature: def sequence[A](list: List[Option[A]]): Option[List[A]]
}

case object MyNone extends OptionTrait[Nothing] {
  override def map[B](f: Nothing => B): OptionTrait[B] = ???

  override def flatMap[B](f: Nothing => OptionTrait[B]): OptionTrait[B] = ???

  override def getOrElse[B >: Nothing](default: => B): B = ???

  override def orElse[B >: Nothing](ob: => OptionTrait[B]): OptionTrait[B] = ???

  override def filter(f: Nothing => Boolean): OptionTrait[Nothing] = ???
}