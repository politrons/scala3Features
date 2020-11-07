package scala.features

object OpaqueTypeFeature extends App{

  opaque type Username = String

  object Domain {

    object Username {
      def apply(value: String): Username = {
        value
      }
    }

    extension(username: Username) {
      def isRoot(): Boolean = username == "politrons"
    }
  }

  import Domain._

  private val username: Username = Username("politrons")
  println(username.isRoot())
}
