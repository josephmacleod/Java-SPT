package readdata;

import java.io.IOException;
import java.sql.*;

public class ReadDB{

  public static void main(String[] args) throws IOException {
     String url = "jdbc:mysql://localhost:3306/buoy_data";
     String username = "root";
     String password = "";
     Connection connection = null; 
     Statement stmt=null;
     
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
     
     try{
      stmt = connection.createStatement();
      String query = "SELECT * FROM spt";

      ResultSet resSet = stmt.executeQuery(query);

      while (resSet.next()) {
        System.out.println(resSet.getString(1) + ", " + resSet.getString(2) + ", "
             + resSet.getString(3)+ ", " + resSet.getString(4));
      }
     } catch (SQLException e) {
       System.out.println(e.toString());
     }
     
 }
 }
