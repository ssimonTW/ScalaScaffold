package Tree

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  // Ex 5. Write a function size that counts the number of nodes (leaves and branches) in a tree.
  def size[A](tree: Tree[A]) : Int = ???

  def apply[A](as: Branch[A]): Tree[A] = ???

  //Ex 6. Write a function path that returns the maximum path length from the root of a tree to any leaf.
  def maximumPath[A](tree: Tree[A], origin: Leaf[A]) : Int = ???
}