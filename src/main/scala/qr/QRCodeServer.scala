package qr

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import com.typesafe.config.ConfigFactory

object QRCodeServer extends App {
  implicit val system = ActorSystem()
  implicit val executor = system.dispatcher
  implicit val materializer = ActorMaterializer()

  val config = ConfigFactory.load()
  val logger = Logging(system, getClass)

  val routes = {
    path("generate") {
      get {
        parameter("msg".as[String]) { msg =>
          complete(HttpResponse(
            StatusCodes.OK,
            entity = HttpEntity(MediaTypes.`image/jpeg`, QRCodeGen.gen(msg))
          ))
        }
      }
    }
  }

  Http().bindAndHandle(routes, config.getString("http.interface"), config.getInt("http.port"))
}