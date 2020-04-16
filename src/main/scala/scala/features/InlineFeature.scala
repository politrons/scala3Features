package scala.features
import scala.compiletime.{constValue, S}

/**
 * Inline is the new and easy way to use Macro is Scala3. Far more easy to use and 
 * dont require a deep knowledges of how Scala compile works internally.
 */
object InlineFeature {

  /**
   * Using [inline] we can provide a compilation time control of my program.
   * Ensuring in this case that is the Boolean type is not true return a compilation error.
   */
  inline def true_assert(b:Boolean, msg:String):Unit =
    inline if b then println(msg) else compiletime.error("This value must be possitive")
  
  true_assert(true, "")

  /**
   * We can use [constValue] to ensure that only some values are allowed in our program in compilation time.
   * Here if we pass an N different to 0 it wont compile.
   */
  inline def onlyNumberZeroAllowed[N] <: Int =
    inline constValue[N] match {
    case 0 => 0
    case _ => compiletime.error("Dude!, only number 0 allowed")
  }

  onlyNumberZeroAllowed[0]
  //  onlyNumberZeroAllowed[2]

  /**
   * In this example we do something cool as well, we only allow some sort of values of Sting, otherwise
   * we return a compilation error.
   * One of the greater things about this, is that it can prevent null values.
   */
  inline def checkValue(value:String) <: String =
    inline value match {
    case "Hello" => "How you doing?"
    case "Hi" => "How you doing?"
    case "Hola" => "Como estas?"
    case _ => compiletime.error("Dude!, you're so rude!")
  }

  checkValue("Hello")
  checkValue("Hi")
//  checkTypes("Ein?")

  /**
   * In this new example we check types allowed in the generics, this is amazing how we can control in compilation
   * time which types we allow in our system
   */
  inline def checkTypes[N](value:N) :Unit =
    inline value match {
    case _:String => ()
    case _:Long => ()
    case _:Boolean => ()
    case _ => compiletime.error("Error dude, that type is not allowed")
  }

  checkTypes("whathever")
  checkTypes(true)
  checkTypes(1981L)
  //  checkTypes(1)
}
