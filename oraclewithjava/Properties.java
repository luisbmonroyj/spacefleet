package oraclewithjava;
/*
  @author
  LuisBernardo Monroy Jaramillo
*/
public interface Properties {
       /*
       final static String RDBMS_NAME = "Oracle";
       final static String DATABASE_NAME = "XE";
       final static String DATABASE_URL= "jdbc:oracle:thin:@localhost:1521/"+DATABASE_NAME;
       final static String DATABASE_USER = "dbUser";//sys, whatever user 
       final static String DATABASE_PASSWORD = "strong"; //Always use a strong password
       final static String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    */
    final static String RDBMS_NAME = "postgresql";
    final static String DATABASE_NAME = "postgres";
    final static String DATABASE_URL= "jdbc:"+oraclewithjava.Properties.RDBMS_NAME+"://localhost:5432/"+oraclewithjava.Properties.DATABASE_NAME;
    final static String DATABASE_USER = "postgres";
    final static String DATABASE_PASSWORD = "Honda*YDP49D"; //Always use a strong password
    final static String DATABASE_DRIVER = "com.jdbc.driver.postgresqlDriver";//?
}
