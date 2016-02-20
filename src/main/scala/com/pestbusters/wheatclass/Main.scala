package com.pestbusters.wheatclass

import java.io.FileWriter
import java.util.Base64

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("my-system")

  startServer(interface = "localhost", port = 8080) {
    path("classify") {
      post {
        entity(as[String]) {e =>
          complete {
            runClassifier(e)
          }
        }
      }
    }
  }

  def runClassifier(s: String): String = {
    val decoder = Base64.getDecoder
    val in = new String(decoder.decode(s))
    val writer = new FileWriter("image.jpg")
    writer.write(in)
    writer.close()
    in
  }
}
