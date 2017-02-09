package process_spt;

import java.io.*;
import java.util.*;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class PlotSPT{
  
  public Hashtable<String,Hashtable> hashrecords;
  
  public PlotSPT(Hashtable<String,Hashtable> records){
    hashrecords = records;
  }
  
  public void getHashtable(ReadDB readDB){
    
  }
  
  public static void main(String[] args) throws IOException {
   Hashtable<String,Hashtable> records = ReadDB.getRecords();
   System.out.println(records);
   DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
   Set<String> date_times = records.keySet();
   for (String date_time:date_times){
    
   }
  }
}
