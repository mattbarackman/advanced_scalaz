import mb.chapter_1.printable._

object Main extends App {
  import scalaz.syntax.show._
  val cat = Cat("quincy", 4, "grey")
  cat.println
}