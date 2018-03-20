
name := "sqlserver-test"
version := "1.0"
scalaVersion := "2.11.8"
val sparkVersion = "2.1.1"

mainClass := Some("sample.SampleMain")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided" //,
  //"com.microsoft.sqlserver" % "mssql-jdbc" % "6.2.2.jre8"
)

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case PathList("org", "slf4j", xs @ _*) => MergeStrategy.discard
  case PathList("org", "apache", "log4j", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

assemblyJarName in assembly := s"sqltest-${version.value}.jar"