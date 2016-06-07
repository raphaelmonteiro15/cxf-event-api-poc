package controllers

import java.io.StringWriter

import org.mongodb.scala.{Document, Observable}
import repository.{Item, ItemRepository}
import javax.inject._

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.ExecutionContext

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class Application @Inject()(itemRepository: ItemRepository)(implicit exec: ExecutionContext) extends Controller {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index = Action.async {
    getItems().map { msg => Ok(msg)}
  }

  def find(id: String) = Action.async {
    getById(id).map { msg => Ok(msg)}
  }

  private def getItems(): Future[String] = {
    val promise: Promise[String] = Promise[String]()
    itemRepository.getItems onComplete(it => {
      it.map( u => {
        it.get.subscribe((results: Seq[Document]) => {
         val items = results.map(a => new Item(a.get("_id").get.asObjectId().getValue.toString,
                                               a.get("codigo").get.asString().getValue,
                                               a.get("nomenclatura").get.asString().getValue,
                                               a.get("item").get.asString().getValue,
                                               a.get("qty").get.asNumber().intValue()
                                ))
          val out = new StringWriter
          mapper.writeValue(out, items)
          val json = out.toString()
          println(json)
          promise.success(json)
        })
      })
    })
    promise.future
  }

  private def getById(id: String): Future[String] = {
    val promise: Promise[String] = Promise[String]()
    itemRepository.getById(id) onComplete(it => {
      it.map( u => {
        it.get.subscribe((results: Seq[Document]) => {
          val items = results.map(a => new Item(a.get("_id").get.asObjectId().getValue.toString,
            a.get("codigo").get.asString().getValue,
            a.get("nomenclatura").get.asString().getValue,
            a.get("item").get.asString().getValue,
            a.get("qty").get.asNumber().intValue()
          ))
          val out = new StringWriter
          mapper.writeValue(out, items)
          val json = out.toString()
          println(json)
          promise.success(json)
        })
      })
    })
    promise.future
  }
}