package scala.features

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
