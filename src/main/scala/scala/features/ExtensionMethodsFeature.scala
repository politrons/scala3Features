package scala.features

/**
 * Extension methods in Scala3 is what we used to call extension class in Scala 2 using [implicit class A(type_you_want_extend){}]
 * Here is more elegant and readable, where we just need once we have the type, use def follow by the type to extend,
 * and then after . write the method attribute we want to extend.
 */
object ExtensionMethodsFeature extends App{

  case class User(name:String, surname:String, age:Int)

  /**
   * Here we define our extension method, once is defined, it can be used in any instance of [User] as 
   * long the user instance is in the same context where this has beem executed.
   */
  def (user:User).getUserInfo():String = s"Name:${user.name}, Surname${user.surname}, Age:${user.age} "
  
  /**
   * We can also add new attributes in the Class, in Scala all attributes access are functions, so basically is another
   * extension method.
   */
  def (user:User).address: String = "Camilo Jose Cela street"
  
  val user = User("Politrons","Picouto", 38)

  /**
   * Once we define the instance, after being the def in the same context, we can use it in our program.
   */
  println(user.getUserInfo())
  println(user.address)

}
