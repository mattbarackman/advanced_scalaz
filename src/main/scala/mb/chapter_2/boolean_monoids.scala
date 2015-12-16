package mb.chapter_2

import scalaz.Monoid

object booleanMonoids {

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def append(a: Boolean, b: => Boolean): Boolean = a && b
    def zero: Boolean = true
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def append(a: Boolean, b: => Boolean): Boolean = a || b
    def zero: Boolean = false
  }

  implicit val booleanXorMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    def append(a: Boolean, b: => Boolean): Boolean = a == !b
    def zero: Boolean = false
  }

}