package Tree

sealed trait Tree[+A]

case class Leaf[A](value: A) extends Tree[A]

case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  // Ex 5. Write a function size that counts the number of nodes (leaves and branches) in a tree.
  def size[A](tree: Tree[A]) : Int = tree match {
    case Branch(l, r) => size(l) + size(r) + 1
    case Leaf(_) => 1
  }

  //Ex 6. Write a function path that returns the maximum path length from the root of a tree to any leaf.
  def maximumPath[A](tree: Tree[A], origin: Leaf[A]) : Int = tree match {
    case Leaf(a) if origin.value.equals(a) => 1
    case Leaf(_) => 0
    case Branch(l, r) => maximumPath(l, origin) + maximumPath(r, origin)
  }

  def apply[A](as: Tree[A]): Tree[A] = as match {
    case branch: Branch[A] => Branch(branch.left, branch.right)
    case leaf: Leaf[A] => leaf
  }
}