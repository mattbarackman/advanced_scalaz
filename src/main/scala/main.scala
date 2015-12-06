import mb.chapter_1.printable._

object Main extends App {
  import scalaz.syntax.show._
  import scalaz.syntax.equal._
  import scalaz.std.option._

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