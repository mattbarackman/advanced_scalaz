package mb.chapter_1.printable
import scalaz.Show
import scalaz.Equal
import scalaz.std.anyVal._
import scalaz.std.string._
import scalaz.syntax.show._
import scalaz.syntax.equal._

case class Cat(name: String, age: Int, color: String)


object Cat {
  implicit val catShow = Show.shows[Cat] { cat => {
    val name = cat.name.shows
    val age = cat.age.shows
    val color = cat.color.shows
    s"$name is a $age year-old $color cat."
  }}

  implicit val catEqual = Equal.equal[Cat] { (cat1, cat2) =>
    cat1.name === cat2.name &&
    cat1.age === cat2.age &&
    cat1.color === cat2.color
  }
}
