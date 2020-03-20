package scala.features

/**
 * Another cool feature that can be found in Haskell, world. The Union type allow using [|]
 * in the definition to tell the compiler that he can expect a type of the group of types defined
 * using that operator to separate one to another.
 */
object UnionTypesFeature extends App {

  case class User(name: String)

  case class Product(name: String)

  case class Basket(products:List[Product])

  /**
   * Having defined previously the ADT, and using operator [|] in the input type of the function,
   * we specify that only a type defined in the signature is allowed.
   * So the compiler will allow only to pass one of those types elements.
   */
  def printUnionTypeOnly(unionType: User | Product | Basket): Unit = {
    unionType match {
      case User(value) => println(value)
      case Product(value) => println(value)
      case Basket(products) => println(products)
      case null => println("Ein?")
    }
  }

  printUnionTypeOnly(User("politrons"))
  printUnionTypeOnly(Product("Coke-Cole"))
  printUnionTypeOnly(Basket(List(Product("Coke-Cole"),Product("Waffles"), Product("Buddweiser") )))
  printUnionTypeOnly(null) // Nulls are allowed, which is not particular cool to be honest.
  //  printUserProduct("Not allowed type") --> It wont compile sice is not one of the union types

}
