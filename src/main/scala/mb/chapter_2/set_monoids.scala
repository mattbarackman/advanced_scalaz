package mb.chapter_2

import scalaz.{Semigroup, Monoid}

object setMonoids {

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = {
    new Monoid[Set[A]] {
      def append(a: Set[A], b: => Set[A]): Set[A] = a union b
      def zero: Set[A] = Set.empty[A]
    }
  }

  implicit val intSetMonoid: Monoid[Set[Int]] = Monoid[Set[Int]]

  implicit def setIntersectionSemigroup[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    def append(a: Set[A], b: => Set[A]): Set[A] = a intersect b
  }

  implicit val intIntersectionSemigroup = Semigroup[Set[Int]]

}