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
		  dataset.addValue(Double.valueOf((String) records.get(date_time).get("Hs")), "Hs", date_time);
	  };
	  JFreeChart lineChartObject = ChartFactory.createLineChart(
		         "Hs","SPT Chart","Date and Time",
		         dataset,PlotOrientation.VERTICAL,
		         true,true,false);

		      int width = 1000; /* Width of the image */
		      int height = 480; /* Height of the image */ 
		      File lineChart = new File( "SPTChart.jpeg" ); 
		      ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
	  
  }
}
