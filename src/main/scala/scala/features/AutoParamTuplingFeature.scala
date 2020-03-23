package scala.features

/**
 * Simple but effective, in Scala2 it's not possible using this DSL, use the tuple without specify the types
 * of each element. Now in Scala3 it's possible have auto param tuples in lambda expresions
 */
object AutoParamTuplingFeature extends App {

    List("hello", "tupple", "without", "types", "in lambdas").zipWithIndex.map((value, index) => println(s"$value - $index"))

}
