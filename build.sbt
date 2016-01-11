name := "AkkaTestClient"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "com.abhi" %% "akkatest" % "1.0.0-SNAPSHOT",
  "com.typesafe.akka" %% "akka-actor" % "2.3.6",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6"
)