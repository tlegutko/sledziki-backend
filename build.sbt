name := "sledziki-backend"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http-core" % "2.4.4",
  "com.typesafe.akka" %% "akka-http-experimental" % "2.4.4",
  "net.glxn" % "qrgen" % "1.4"
)