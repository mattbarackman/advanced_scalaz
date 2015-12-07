package mb.chapter_1.printable

trait Printable[A] {
  def format(value: A): String
}

object PrintDefaults {
  implicit val stringPrintable = new Printable[String] {
    def format(input: String) = input
  }
  implicit val intPrintable = new Printable[Int] {
    def format(input: Int) = input.toString
  }
  implicit val catPrintable = new Printable[Cat] {
    def format(input: Cat) = {
      val name = Print.format(input.name)
      val age = Print.format(input.age)
      val color = Print.format(input.color)
      s"$name is a $age year-old $color cat."
    }
  }
}

object Print {
  def format[A](input: A)(implicit printable: Printable[A]): String = {
    printable.format(input)
  }
  def print[A: Printable](input: A): Unit = {
    println(format(input))
  }
}

object PrintSyntax {
  implicit class PrintOps[A: Printable](value: A) {
    def format(): String = Print.format(value)
    def print(): Unit = Print.print(value)
  }
}