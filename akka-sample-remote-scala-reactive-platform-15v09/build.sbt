name := """akka-sample-remote-scala-reactive-platform-15v09"""

version := "15v09p01"

libraryDependencies ++= Seq(
  TypesafeLibrary.akkaRemote.value
)



fork in run := true