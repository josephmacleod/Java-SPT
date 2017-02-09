package process_spt;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ReadDB{
 private static Hashtable<String,Hashtable> records = new Hashtable<String,Hashtable>();
 
 public static Hashtable<String,Hashtable> getRecords() throws IOException {
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
    Hashtable<String,String> record = new Hashtable<String,String>();
    record.put("Hs",resSet.getString(2));
    record.put("Tz",resSet.getString(3));
    record.put("Battery",resSet.getString(4));
    records.put(resSet.getString(1), record);

   }
  } catch (SQLException e) {
   System.out.println(e.toString());
  }

  return records;
 }

}
