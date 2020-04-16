package scala.features

import java.time.LocalDate

import scala.features.ImplicitFunctionFeature.TypeClass

/**
 * In Scala3 Implicit is not longer part of the language, and the use of [given] and [using] is required.
 * I found it more readable and also secure to avoid nasty and unsecure implicit conversions.
 * Also now is possible use the really useful implicit functions. Which allow us define as implicit
 * a function to be passed as dependency in context.
 */
object ImplicitFunctionFeature extends App {

  case class User(name: String)

  /**
   * Implicit type
   * -------------
   * The syntax is use keyboard [given] and type, or providing a name then use keyboard [as] and the type you want to
   * define as implicit in the context where you're. Then you define the value of the implicit.
   */
  given User = User("Politons")
//  given myuser as User = User("Politons")
  
  /**
   * Now instead the keyboard [implicit] in the definition of the method, we use [using] and the we pass the type 
   * defined in the implicit.
   *
   * @param using
   */
  def getUserName()(using user: User): String = {
    user.name
  }

  println(getUserName())

  /**
   * Implicit function
   * ------------------
   * As I mention before, now in Scala3 we're able to define Implicit functions to be passed as argument into methods.
   */
  given (User => String) = user => user.name

  def getUserNameByFunc()(using func: (User => String)): String = {
    func(User("Politrons in a function"))
  }

  println(getUserNameByFunc())

  /**
   * Type classes
   * -------------
   * Type classes pattern in Scala3 works quite similar and in Scala2 just changing the syntax from [implicit] declaration
   * to [given A as B] as we saw before.
   * We define some many given as implementation of the [Type class] we want, and then having a generic function with 
   * [use TypeClass[T]] the compiler pick up one implementation or another.
   */
  trait TypeClass[T] {
    def getValue(): T
  }

  /**
   * Three different implementations of TypeClass for Int, String and Udser type
   */
  given TypeClass[Int] = new TypeClass[Int] {
    def getValue(): Int = {
      1981
    }
  }

  given TypeClass[String] = new TypeClass[String] {
    def getValue(): String = {
      "hello type class world"
    }
  }

  given TypeClass[User] = new TypeClass[User] {
    def getValue(): User = {
      User("politrons")
    }
  }

  /**
   * Generic function to invoke one of the three previoius implementations depending of the generic type T passed in
   * the function.
   * @param using implicit implementation of thr Type Class
   * @tparam T generic to determine which implementation use.
   */
  def getTypeClassValue[T]()(using a: TypeClass[T]): T = {
    a.getValue()
  }
  
  println(s"Type class:${getTypeClassValue[Int]()}")
  println(s"Type class:${getTypeClassValue[String]()}")
  println(s"Type class:${getTypeClassValue[User]()}")

}
