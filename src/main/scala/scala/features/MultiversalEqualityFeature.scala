package scala.features

/**
 * In Scala 2 you cannot compare values of elements of different types.
 * Now with Scala3 using [Eql[Type1, Type2]] we can compare Type1 == Type2 
 */
object MultiversalEqualityFeature extends App {

  given Eql[Int, String] = Eql.derived
  println(3 == "3")

  /**
   * Not compiling since Eql[String, Int] is not defined.
   */
  //println("3" == 3)

  given Eql[Double, Int] = Eql.derived
  println(10.0 == 10)
  println(10.1 == 10)
  
  case class A(value:Int)
  case class B(value:Int)
  
  given Eql[A,B] = Eql.derived
  
  println(A(1) == B(1))
}
