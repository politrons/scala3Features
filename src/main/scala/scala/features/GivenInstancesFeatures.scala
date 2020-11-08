package scala.features


/**
 * Given instandes "givens" is the new way in Scala3 to create instances that can be used in the context where is
 * defined/imported. Just like we used to do with [implicits], but instead of use that keyboard,we use 
 * [given] to define an instance/variable in context. And [using] to be used from a function.
 * Also, just like with impliciy, we can still usign [implicitly[T]] to get the instance/variable not in the invokation
 * of the function, but inside the function.
 */
object GivenInstancesFeatures extends App {

  case class Male()

  case class Female()

  trait Human[T] {
    def getSex(): String
  }

  /**
   * Declaration of givens
   * ----------------------
   * Syntax is [given] variable name [as] [Type] = implementation
   */
  
  given male as Human[Male] = new Human {
    override def getSex(): String = "Male"
  }

  given female as Human[Female] = new Human {
    override def getSex(): String = "Female"
  }

  trait Politrons extends Human[Male] {
    def getName(): String
  }

  given politrons(using human: Human[Male]) as Politrons = new Politrons {
    override def getSex(): String = human.getSex()

    override def getName(): String = "Politrons"

  }

  /**
   * Consumers of givens
   * -------------------
   * Syntax is [using] variable name : [Type]
   */
  def getHumanSex[T]()(using human:Human[T]):String={
    human.getSex()
  }

  def getHumanSexByImplicitly[T]():String={
    val human = implicitly[Human[Male]] 
    human.getSex()
  }

  def getPolitrons()(using politrons:Politrons):(String, String)={
    (politrons.getSex(), politrons.getName())
  }
  
  println(getHumanSex[Male]())
  println(getHumanSex[Female]())
  println(getHumanSexByImplicitly())
  println(getPolitrons())

}
