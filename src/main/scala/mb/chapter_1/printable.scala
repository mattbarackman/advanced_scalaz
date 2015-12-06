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
}

object Print {

  def format[A](input: A)(implicit printable: Printable[A]): String = {
    printable.format(input)
  }
  def print[A](input: A)(implicit printable: Printable[A]): Unit = {
    println(format(input))
  }
}

object PrintSyntax {
  implicit class PrintOps[A](value: A) {
    def format(implicit printable: Printable[A]): String = {
      printable.format(value)
    }
    def print(implicit printable: Printable[A]): Unit = {
      println(printable.format(value))
    }
  }
}