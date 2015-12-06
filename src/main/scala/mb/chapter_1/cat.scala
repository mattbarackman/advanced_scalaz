package mb.chapter_1.printable
import scalaz.Show
import scalaz.std.anyVal._
import scalaz.std.string._
import scalaz.syntax.show._

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

  implicit val catShow = Show.shows[Cat] { cat => {
    val name = cat.name.shows
    val age = cat.age.shows
    val color = cat.color.shows
    s"$name is a $age year-old $color cat."
  }}

}
