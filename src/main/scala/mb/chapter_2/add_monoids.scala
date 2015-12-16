package mb.chapter_2

import scalaz.Monoid
import scalaz.syntax.monoid._

object addMonoids {

  implicit val doubleAddMonoid: Monoid[Double] = new Monoid[Double]{
    def append(a: Double, b: => Double): Double = a + b
    def zero: Double = 0
  }

  object SuperAdder {
    def add[A: Monoid](items: List[A]): A = items.foldLeft(mzero[A]){ _ |+| _ }
  }

  object Order {

    case class Order(totalCost: Double, quantity: Double)

    implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
      def append(o1: Order, o2: => Order) =
        Order(o1.totalCost + o2.totalCost, o1.quantity + o2.quantity)
      def zero = Order(0,0)
    }

  }

}


