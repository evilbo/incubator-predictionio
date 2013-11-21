import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "predictionio-admin"
    val appVersion      = "0.6.4"

    val appDependencies = Seq(
      "io.prediction" %% "predictionio-commons" % "0.6.4",
      "io.prediction" %% "predictionio-output" % "0.6.4",
      "com.github.nscala-time" %% "nscala-time" % "0.4.2",
      "commons-codec" % "commons-codec" % "1.8"
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      playAssetsDirectories <+= baseDirectory / "enginebase",
      resolvers += (
        "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
      ),
      scalacOptions ++= Seq("-deprecation","-unchecked","-feature")
    )

}
