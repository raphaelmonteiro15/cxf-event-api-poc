package controllers


import org.mongodb.scala.Document
import repository.ItemRepository
import javax.inject._

import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Application @Inject()(itemRepository: ItemRepository)(implicit exec: ExecutionContext) extends Controller {

  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */

  def index = Action.async {
    getItems().map { msg => Ok(msg) }
  }

  private def getItems(): Future[String] ={
    val promise: Promise[String] = Promise[String]()
    val items = itemRepository.getItems
    items onComplete(it => {
      it.get.subscribe((results: Seq[Document]) => promise.success(results.head.get("nomenclatura").get.asString().getValue))
    })
    promise.future
  }



}
