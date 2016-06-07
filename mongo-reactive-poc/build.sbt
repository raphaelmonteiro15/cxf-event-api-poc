name := """mongo-reactive-poc"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.1", 
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
//resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.4"
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.7.4"