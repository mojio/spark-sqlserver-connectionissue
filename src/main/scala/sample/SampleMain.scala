package sample

import org.apache.spark.sql.SparkSession

object SampleMain {
  def main(args: Array[String]): Unit = {

    val sparkSession = SparkSession.builder.
      master("yarn")
      .appName("sqltest")
      .getOrCreate()


    val url = "jdbc:sqlserver://SERVERNAME.database.windows.net:1433;database=auditlogs;user=USER;password=PASSWORD;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
    val driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
    val tableName = "KeyOperationsLogs"

    // TODO: I should probably add something to the sql properties??

    val keyauditlogs_table = sparkSession.read.jdbc(url, tableName, new java.util.Properties())

    keyauditlogs_table.show(false)
  }
}
