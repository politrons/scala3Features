package scala.features

import java.time.LocalDate

/**
 * In Scala3 Implicit is not longer part of the language, and the use of [given] and [using] is required.
 * I found it more readable and also secure to avoid nasty and unsecure implicit conversions.
 * Also now is possible use the really useful implicit functions. Which allow us define as implicit
 * a function to be passed as dependency in context.
 */
object ImplicitFunctionFeature extends App {

  case class User(name: String)

  /**
   * The syntax is use keyboard [given] providing a name then use keyboard [as] and the type you want to
   * define as implicit in the context where you're. Then you define the value of the implicit.
   */
  given MyUser as User = User("Politons")

  /**
   * Now instead the keyboard [implicit] in the definition of the method, we use [using] and the we pass the type 
   * defined in the implicit.
   * @param using
   */
  def getUserName()(using user:User):String = {
    user.name
  }
  
  println(getUserName())

  /**
   * As I mention before, now in Scala3 we're able to define Implicit functions to be passed as argument into methods.
   */
  given MyFunctionName as (User => String) = user => user.name

  def getUserNameByFunc()(using func:(User => String)):String = {
   func(User("Politrons in a function"))
  }

  println(getUserNameByFunc())
  
}
