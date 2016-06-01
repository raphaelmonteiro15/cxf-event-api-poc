name := """reactive-mongo"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)


fork in run := true

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "reactivemongo" % "0.11.11"
)