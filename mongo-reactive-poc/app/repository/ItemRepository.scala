package repository

import javax.inject._

import org.mongodb.scala.bson.BsonObjectId
import org.mongodb.scala.{Document, MongoClient, MongoDatabase, Observable}

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

@Singleton
class ItemRepository {

  def getItems(implicit ec: ExecutionContext): Future[Observable[Seq[Document]]] ={
    val client: MongoClient = MongoClient()
    val database: MongoDatabase = client.getDatabase("test")
    return Future{database.getCollection("item").find().collect()}
  }

  def getById(id : String)(implicit ec: ExecutionContext): Future[Observable[Seq[Document]]] ={
    val client: MongoClient = MongoClient()
    val database: MongoDatabase = client.getDatabase("test")
    return Future{database.getCollection("item").find(Document("_id" -> BsonObjectId(id))).collect()}
  }

}