package com.server

import akka.actor.ActorSystem
// import com.models.Business
import com.support.CORSSupport
import com.services.GTRetrievalService
import spray.http.MediaTypes
import spray.routing.{Route, SimpleRoutingApp}

object GTServer extends App with SimpleRoutingApp with CORSSupport{


  implicit val actorSystem = ActorSystem()


  //Custom directive to replace the inclcusion of the stated return type header
  def getJson(route: Route) = get{
    respondWithMediaType(MediaTypes.`application/json`){
      route
    }
  }

  //Define Each route independently as lazy vals to keep code clean
  //Link the names of each route in the start server method

  lazy val helloRoute = get {
      cors{
        path("hello") {
          complete {
            "Welcome to the Geo Tagging Service \n here are a list of the available routes:"
          }
        }
      }
  }
  
  lazy val getGeoTagRoute = getJson {
      cors{
        path("geoTaggings" / "addresses" / Segment) { address =>
          complete {
            GTRetrievalService.getGeoTag(address)
          }
        }
      }
  }

  startServer(interface = "localhost", port = 8082) {
    helloRoute~
    getGeoTagRoute
  }

}