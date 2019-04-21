name := """check-evolutions-for-2.7.x"""
organization := "com.github.masahitojp"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

val scalikejdbcVersion    = "3.3.2"

libraryDependencies ++= Seq(evolutions, jdbc,
  "org.scalikejdbc" %% "scalikejdbc" % scalikejdbcVersion excludeAll (
    ExclusionRule(organization = "org.apache.commons",
                  name = "commons-dbcp2")
  ),
  "org.scalikejdbc"    %% "scalikejdbc-syntax-support-macro" % scalikejdbcVersion,
  "org.scalikejdbc"    %% "scalikejdbc-config"               % scalikejdbcVersion,
  "org.scalikejdbc"    %% "scalikejdbc-play-dbapi-adapter"   % "2.7.0-scalikejdbc-3.3",
)
libraryDependencies += guice
libraryDependencies += "org.postgresql"     % "postgresql"                        % "42.1.1"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.github.masahitojp.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.github.masahitojp.binders._"
