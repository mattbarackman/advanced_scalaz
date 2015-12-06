import mb.chapter_1.printable._

object Main extends App {
  import PrintSyntax._
  val cat = Cat("quincy", 4, "grey")
  Print.print(cat)
  cat.print
}