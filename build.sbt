lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3Features",
    description := "Examples of Scala3 features using Dotty",
    version := "0.1.0",
    scalaVersion := "0.23.0-RC1"
  )
