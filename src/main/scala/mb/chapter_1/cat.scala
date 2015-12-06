package mb.chapter_1.printable

case class Cat(name: String, age: Int, color: String)

object Cat {
  import PrintDefaults._
  implicit val catPrintable = new Printable[Cat] {
    def format(input: Cat) = {
      val name = Print.format(input.name)
      val age = Print.format(input.age)
      val color = Print.format(input.color)
      s"$name is a $age year-old $color cat."
    }
  }
}