package scala.features

/**
 * Scala3 provide operator [&] for intersection type, which allow us to create types that contains two types.
 * using [type C = A & B] allow us using in C as type, all access functions and attributes of A and B
 */
object IntersectionTypesFeature extends App{

  case class User(name: String)

  case class Product(name: String)

  /**
   * Type UserService which expose the function getUser
   */
  sealed trait UserService() {
    def getUser(): User
  }

  /**
   * Type ProductService which expose the function getProduct
   */
  sealed trait ProductService {
    def getProduct(): Product
  }

  /**
   * Once we create this intersection type, we're able to refere the access functions and attributes of both services
   */
  type IntersectionType = UserService & ProductService

  /**
   * This a simple and common implementation of both Services which it can be refered as Intersetion type [IntersectionType]
   * created previously.
   * @param user
   * @param product
   */
  final case class UserProduct(user: User, product: Product) extends UserService with ProductService{
    def getUser() = user
    def getProduct() = product
  }

  val intersectionType: IntersectionType = UserProduct(User("Politron"), Product("coca-cola"))
  println(intersectionType.getUser())
  println(intersectionType.getProduct())
}
