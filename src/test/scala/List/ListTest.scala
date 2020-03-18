package List

import org.scalatest.{BeforeAndAfterEach, MustMatchers, WordSpec}

class ListTest extends WordSpec with MustMatchers with BeforeAndAfterEach {

  "tail" should {
    "return the last elements from a list" in {
      List.tail[Int](List(1, 2, 3, 4)) mustBe List(2, 3, 4)
    }
  }

  "drop" should {
    "remove the last element from a list" in {
      List.drop[Int](1, List(1, 2, 3)) mustBe List(2, 3)
    }

    "remove the last 2 elements from a list" in {
      List.drop[Int](2, List(1, 2, 3)) mustBe List(3)
    }
  }
}
