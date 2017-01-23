package readdata;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

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

        
      Hashtable<String,Hashtable> records = new Hashtable<String,Hashtable>();
      
      while (resSet.next()) {
        Hashtable<String,String> record = new Hashtable<String,String>();
        record.put("Hs",resSet.getString(2));
        record.put("Tz",resSet.getString(3));
        record.put("Battery",resSet.getString(4));
        records.put(resSet.getString(1), record);
          
        System.out.println(records);
      }
     } catch (SQLException e) {
       System.out.println(e.toString());
     }

     
 }
 }
