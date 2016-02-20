package com.pestbusters.wheatclass

import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp

object Main extends App with SimpleRoutingApp {
  implicit val system = ActorSystem("my-system")

  startServer(interface = "localhost", port = 8080) {
    path("classify") {
      post {
        entity(as[String]) {e =>
          complete {
            e
          }
        }

      }
    }
  }
}
