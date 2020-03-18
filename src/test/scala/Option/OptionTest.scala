package Option

import org.scalatest.{BeforeAndAfterEach, MustMatchers, WordSpec}

class OptionTraitTest extends WordSpec with MustMatchers with BeforeAndAfterEach {

  "map" when {

    "map MyOption" in {
      val myOptionInt = MyOption(1)
      val mappedOptionInt = myOptionInt.map(_ + 1)

      mappedOptionInt mustBe new MyOption[Int](2)
    }

    "map MyNone" in {
      val myNone = MyNone

      (myNone map (_ => 2)) mustBe myNone
    }

    "map2 MyOption" in {
      val myOption1 = MyOption(1)
      val myOption2 = MyOption(2)

    }
  }

  "flatMap" when {
    val functionPlus2 = (number: Int) => new MyOption[Int](number + 2)

    "Adding 2 function" in {
      MyOption(1).flatMap(functionPlus2) mustBe MyOption(3)
      MyNone.flatMap(functionPlus2) mustBe MyNone
    }
  }

  "getOrElse" in {
    MyOption(1) getOrElse (0) mustBe 1
    MyNone getOrElse (0) mustBe 0
  }

  "orElse" in {
    (MyOption(1) orElse MyOption(0)) mustBe MyOption(1)
    (MyNone orElse MyOption(0)) mustBe MyOption(0)
  }

  "filter" in {
    val filterFunction = (number: Int) => number - 1 == 0
    MyOption(1).filter(filterFunction) mustBe MyOption(1)
    MyOption(0).filter(filterFunction) mustBe MyNone
    MyNone.filter(filterFunction) mustBe MyNone
  }

}
