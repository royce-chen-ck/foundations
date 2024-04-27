package exercises.generic

import java.time.LocalDate
import java.time.format.DateTimeFormatter

import exercises.generic.GenericFunctionExercises._
import org.scalacheck.{Arbitrary, Gen}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.ScalaCheckDrivenPropertyChecks

import scala.util.Try

class GenericFunctionExercisesTest extends AnyFunSuite with ScalaCheckDrivenPropertyChecks {

  ////////////////////
  // Exercise 1: Pair
  ////////////////////

  test("Pair swap") {
    assert(names.swap == Pair("Elisabeth", "John"))
    assert(ages.swap == Pair(46, 32))
  }

  test("Pair map") {
    assert(names.map(_.length) == Pair(4, 9))
    assert(ages.map(_ + 3) == Pair(35, 49))
  }

  test("Pair decoded") {
    // println(decoded)
    // assert(0 == 1)
  }

  test("Pair zipWith") {
    assert(Pair(0, 2).zipWith(Pair(3, 4))((x, y) => x + y) == Pair(3, 6))
  }

  test("Pair zipTrip") {
    case class ProductWithDescription(product: String, price: Double, description: String)
    val productsTrip = productNames.zipTrip(productPrices, productDescriptions)(Product)((p: Product, s: String) => 
      ProductWithDescription(p.name, p.price, s)
    )
    assert(productsTrip == Pair(ProductWithDescription("Coffee", 2.5, "Hot"), ProductWithDescription("Plane ticket", 329.99, "High")))
  }

  test("Pair productNames") {
    assert(products == Pair(Product("Coffee", 2.5), Product("Plane ticket", 329.99)))
  }

  ////////////////////////////
  // Exercise 2: Predicate
  ////////////////////////////

  test("Predicate &&") {}

  test("Predicate ||") {}

  test("Predicate flip") {}

  ////////////////////////////
  // Exercise 3: JsonDecoder
  ////////////////////////////

  test("JsonDecoder UserId") {}

  test("JsonDecoder LocalDate") {}

  test("JsonDecoder weirdLocalDateDecoder") {}

}
