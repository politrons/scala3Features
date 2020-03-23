package scala.features

/**
 * Scala3 brings finally enum types, one of the good featuers of Java, finally in Scala.
 */
object EnumTypesFeatures extends App {

  /**
   * It use [enum] keyboard and in case the constructor accept a value,it's defined there.
   * Then we define with [case] all elements of that enum, and in case the enum has a constructor, 
   * it will inoke that constructor.
   * Also if we want to expose any function in the enum, we will define [def] inside the Enum.
   */
  enum Fruit(flavior: String) {

    def getFlavior: String = flavior

    case Apple extends Fruit("sweet")

    case Bannana extends Fruit("sweet")

    case Pineapple extends Fruit("bitter")

    case Orange extends Fruit("bitter")

  }

  /**
   * We can access statically to the enum elements as we will in Java enum.
   */
  println(Fruit.Apple)
  println(Fruit.Apple.getFlavior)
  println(Fruit.Orange)
  println(Fruit.Orange.getFlavior)

  /**
   * We can iterate over all elements of the enum using [Enum.values]
   */
  for (fruit <- Fruit.values) {
    println(fruit)
  }
}
