package readdata;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class IterateSPT {
  
  public static void main(String[] args) throws IOException {
    String directory_path = "E:\\Documents\\Object Oriented Programming\\James Morrison\\Example file read\\spt_files";
    
    File folder = new File(directory_path);
    File[] listOfFiles = folder.listFiles();
   
    StoreSPT storeSPT = new StoreSPT();
    
    for (File file : listOfFiles) {
      if (file.isFile()) {
        ReadSPT spt_data = new ReadSPT(file.getPath());
        String[] file_data = spt_data.OpenFile();
        DataSPT dataSPT = new DataSPT(file_data, file.getPath());
        storeSPT.writeRecord(dataSPT);
        
      } 
      
    };
    
  }
}
