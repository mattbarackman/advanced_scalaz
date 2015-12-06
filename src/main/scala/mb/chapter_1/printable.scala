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
  def format[A](input: A)(implicit printer: Printable[A]): String = {
    printer.format(input)
  }
  def print[A](input: A)(implicit printer: Printable[A]): Unit = {
    println(format(input))
  }
}

case class Cat(name: String, age: Int, color: String)
