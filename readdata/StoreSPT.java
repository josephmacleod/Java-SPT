package readdata;
import java.sql.*;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class StoreSPT{
  
  String url = "jdbc:mysql://localhost:3306/buoy_data";
  String username = "root";
  String password = "";
  Connection connection = null; 
  Statement stmt=null;
 
  public StoreSPT(){
    try {
      System.out.println("Loading JDBC driver...");
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC driver successfully loaded!");
      connection = DriverManager.getConnection(url, username, password);
  
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }
  
  public void writeRecord(DataSPT dataSPT){
    try {
      stmt = connection.createStatement();
      System.out.println(dataSPT.datetime + " was added to the spt table.");
      SimpleDateFormat date_formater = new SimpleDateFormat("yyyy-MM-dd'T'hh'h'mm");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

      java.util.Date date_time = null;
      try {
        date_time = date_formater.parse(dataSPT.datetime);
      } catch (java.text.ParseException e) {
        
      }
      
      String sql = "INSERT INTO spt (date_time, Hs, Tz, Battery)" +
        " VALUES ('" + sdf.format(date_time) + "', "  + dataSPT.hs + ", " + dataSPT.tz + ", " + dataSPT.battery + ")";
      
      stmt.executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println(e.toString());
    }
  }

}
