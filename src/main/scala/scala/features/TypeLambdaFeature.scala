package scala.features

/**
 * Scala 3 brings lambda types wich alow you dont have to specify generic types in the
 * type defined but in the description using [=>>] operator
 */
object TypeLambdaFeature extends App {

  /**
   * In previous versions of Scala2
   */
  type oldTupleTypes[A, B] = (A, B)

  /**
   * With lambda type we can now specify the types out of the type definition, so the compiler
   * it will infer and it will onyl allow values that match the type
   */
  type tupleTypes =[A, B] =>> (A, B)

  val tupleStringInt: tupleTypes[String, Int] = ("hello", 1)
  //val tupleStringString: tupleTypes[String, Int] = ("hello", "Not_compiling") --> it wont compile
  println(tupleStringInt)


  class A

  case class B(value: String) extends A

  /**
   * Specify a list that only allows subtypes of A
   */
  type SpecificListType =[B <: A] =>> List[B]

  val bList: SpecificListType[B] = List(B("Hello lambdas and generic types in types"))
  //val stringList: SpecificListType[String] = List("Hello") --> it wont compile since String is not A class
  println(bList)
  /**
   * Specific Map key values types
   *
   * @tparam A
   * @tparam B
   */
  type StringKeyValueMap =[A <: String, B] =>> Map[A, B]

  val stringKeyMap: StringKeyValueMap[String, Int] = Map("hello" -> 1)
  //val customMapNotCompiling: KeyValueMap[String, Int] = Map(1 -> 1) //--> Not compiling
  println(stringKeyMap)

}
