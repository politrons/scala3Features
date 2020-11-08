/**
 * Simple and cool feature. Now with Scala3 a class is not need it to define a class.
 * We can just use @main annotation in the file and it will be invoked as a main method.
 */
@main def bla () = {
  noBraketssNeedit(1)
  forLoop
  val function = curryingFunction("hello")
  function(1981)
 
  /**
   * Now we can define a function that expect a generic type and pass it once, the function is defined.
   */
  val genericTypeFunc = firstElement
  genericTypeFunc(List("hello", "world"))
  genericTypeFunc(List(1,2,3))
}

/**
 * Also no brackets are need it in multiline function. 
 * Also the if now not need parenthesis and brackers. Another wink to Haskell 
 */
def noBraketssNeedit(value:Int) = 
  val output = if value == 1 then
    "Hello world"
  else 
    "Go **** yourself"
  println(output)

/**
 * In Scala3 we can have so much simple for loops without braces, and using do. 
 */
def forLoop = 
  for 
    i <- 1 to 10
    z <- 1 to 20
  do println(i + z)

/**
 * Now with function when we invoke this as currying function, we dont have to set the second argument with [_]
*/
def curryingFunction(value:String)(number:Int) = {
  println(s"$value - $number")
}

def firstElement[T](list:List[T]) = println(list(0))



