package scala.features

/**
 * Scala3 now allow have trait with parameters like if a class it has in constructor.
 */
object TraitParamsFeature extends App {

  /**
   * Argument in Trait class that it will pass just when this trait it's implemented by a class that pass the argument.
   */
  trait Human(name: String) {
    def getName(): String = name
  }

  case class Male(name: String) extends Human(name)

  case class Female(name: String) extends Human(name)

  /**
   * Not compile since it's extends two classes that has a trait with argument, so which one it should prevale?
   */
  //case class Androgen(name: String) extends Male(name) with Female(name) 

  println(Male("Politrons").getName())
  println(Female("Esther").getName())

}
