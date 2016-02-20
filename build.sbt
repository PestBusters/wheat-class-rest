name := "wheat-class-rest"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  "io.spray" %% "spray-routing" % "1.3.1",
  "io.spray" %% "spray-client" % "1.3.1"
)
    