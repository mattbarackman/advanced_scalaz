import mb.chapter_1.printable._
import mb.chapter_2.addMonoids.Order.Order
import mb.chapter_2.addMonoids.SuperAdder
import mb.chapter_2.booleanMonoids.booleanAndMonoid
import mb.chapter_2.setMonoids.setUnionMonoid

object Main extends App {

  import scalaz.syntax.show._
  import scalaz.syntax.equal._
  import scalaz.std.option._
  import scalaz.syntax.monoid._

  def chapter_1() = {

    val cat1 = Cat("quincy", 4, "grey")
    val cat2 = Cat("jasmine", 2, "white")
    val cat3 = Cat("jasmine", 2, "white")

    val optionCat1: Option[Cat] = Some(cat1)
    val optionCatNone: Option[Cat] = None

    cat1.println
    cat2.println

    println("cat1 === cat2 : " + (cat1 === cat2))
    println("cat1 =/= cat2 : " + (cat1 =/= cat2))
    println("cat2 === cat3 : " + (cat2 === cat3))
    println("optionCat1 === optionCatNone : " + (optionCat1 === optionCatNone))
    println("optionCat1 =/= optionCatNone : " + (optionCat1 =/= optionCatNone))
  }

//  chapter_1()

  def chapter_2() = {

    println(true |+| true)
    println(true |+| false)
    println(false |+| true)
    println(false |+| false)

    println(SuperAdder.add(List(true, true, true)))
    println(SuperAdder.add(List(true, false, true)))

    val setA = Set[Int](1,2,3)
    val setB = Set[Int](3,4,5)

    println(setA |+| setB)
    println(SuperAdder.add(List(setA, setB)))

    val order1 = new Order(1, 2)
    val order2 = new Order(5, 2)
    val order3 = new Order(10, 20)
    val combinedOrder = order1 |+| order2
    println(combinedOrder.totalCost)
    println(combinedOrder.quantity)
    val combinedOrder2 = SuperAdder.add(List(order1, order2, order3))
    println(combinedOrder2.totalCost)
    println(combinedOrder2.quantity)
  }

  chapter_2()

}