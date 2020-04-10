package Tree

import org.scalatest.{BeforeAndAfterEach, MustMatchers, WordSpec}

class TreeTest extends WordSpec with MustMatchers with BeforeAndAfterEach {

  "size" should {

    "return the total number of nodes" in {
      val size = Tree.size(Tree(Branch(Leaf(1), Leaf(2))))

      size mustBe 3
    }

    "" in {
      val size = Tree.size(Tree(Branch(Branch(Leaf(1), Branch(Leaf(3), Leaf(4))), Leaf(2))))

      size mustBe 7
    }

    "maximum path" in {
      val maxPath = Tree.maximumPath(Tree(Branch(Branch(Leaf(1), Branch(Branch(Leaf(5), Leaf(6)), Leaf(4))), Leaf(2))), Leaf(2))

      maxPath mustBe 1
    }
  }
}
