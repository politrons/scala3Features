package scala.features

/**
 * Another cool feature of Scala3 is [Export Clauses] which provide a neat way to 
 * expose the functions/attributes of one class from another.
 * Having a class that instanciate another class, we might want to dont have to implement
 * adapter patter, and have to write again all the functions, from the class we just instanciate.
 * Well now, just using form the class [export instance.function_to_export] we can expose that
 * function from our class as adapter patter it will.
 */
object ExportClausesFeature extends App {

  /**
   * Having a simple case class with two methods
   */
  case class User(name: String, age: Int) {
    def getName(): String = name

    def getAge(): Int = age
  }

  /**
   * We have another class where we just instanciate a User, but for the sake of privacy we
   * just want to expose the name of the user.
   */
  class Politrons() {
    private val user = User("Politrons", 38)

    /**
     * we will just expose what we want from the user. And then automatically, a method in Politrons class
     * [getName] it will be created.
     */

    export user.getName

  }

  /**
   * If you notice,yes in Scala3 the [new] to create instances, is not lomnger need it, we can do it just like case class.
   */
  val politrons = Politrons()
  println(politrons.getName())
  /**
   * Not compiling since is not exported.
   */
  //println(politrons.getAge()) 

}
