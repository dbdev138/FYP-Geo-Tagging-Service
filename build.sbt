name := "FYP-Geo-Tagging-Service"

version := "1.0"

scalaVersion := "2.11.7"

resolvers += "spray repo" at "http://repo.spray.io"

val sprayVersion = "1.3.3"

libraryDependencies ++= Seq(
     //AKKA
     "com.typesafe.akka" %% "akka-actor" % "2.3.6",
     //Spray IO
     "io.spray" %% "spray-routing" % sprayVersion,
     "io.spray" %% "spray-client" % sprayVersion,
     "io.spray" %% "spray-testkit" % sprayVersion % "test",
     //JSON
     "org.json4s" %% "json4s-native" % "3.2.10",
     //Lift
    "net.liftweb" % "lift-json_2.10" % "3.0-M1",
     //Logging
     "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
     "ch.qos.logback" % "logback-classic" % "1.1.2",
     //Test
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
     //Mockito
     "org.mockito" % "mockito-all" % "1.9.5" % "test",
     //Slick Database
    "com.typesafe.slick" %% "slick" % "3.0.0",
    "org.slf4j" % "slf4j-nop" % "1.6.4"
    )


// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.11"



fork in run := true

fork in run := true