package scala.features

/**
 * Scala3 provide some new features of the already incredible patter matching feature.
 */
object PatternMatchingFeature extends App {

  /**
   * Boolean Match
   * -------------
   * Now in Scala3 we can create an Object withn unapply(Type) function that return boolean
   * that can be used in the pattern mathing as long as the match type match with the [unapply(Type)] function.
   */

  object KnownUsers {
    def unapply(user: String): Boolean = List("politron", "jhon", "wick", "neo").contains(user)
  }

  object KnownFruits {
    def unapply(fruit: String): Boolean = List("orange", "bannan", "apple", "pinneapple").contains(fruit)
  }

  "politron" match {
    case s@KnownUsers() => println(s"$s is known user")
    case s@KnownFruits() => println(s"$s is known fruit")
    case s => println(s"$s I dont know you")
  }
  "apple" match {
    case s@KnownUsers() => println(s"$s is known user")
    case s@KnownFruits() => println(s"$s is known fruit")
    case s => println(s"$s I dont know you")
  }
  "foo" match {
    case s@KnownUsers() => println(s"$s is known user")
    case s@KnownFruits() => println(s"$s is known fruit")
    case s => println(s"$s I dont know you")
  }

  /**
   * Product Match
   * -------------
   * Now in Scala3 we can create an Object withn unapply(Type) function, passing the arguments of that construction 
   * that return an instance of that Type to be matched.
   * Then in the class definition we will have to make it extends [product] and implement [_n] function for each
   * argument of the constructor. The rest of functions [canEqual] [productArity] [productElement] need to be 
   * implemented since you extend Product.
   */
  
  class User(name: String, age: Int) extends Product {

    def _1 = name

    def _2 = age

    // Not used by pattern matching: Product is only used as a marker trait.
    def canEqual(that: Any): Boolean = ???

    def productArity: Int = ???

    def productElement(n: Int): Any = ???

  }
  
  object User {
    def unapply(data:(String,Int)): User = new User(data._1, data._2)
  }

  ("Politrons", 38) match {
    case User(n, a) => println(s"name: $n, age: $a")
  }
}
