package process_spt;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class ReadSPT{
  
  private String path;
  
  public ReadSPT(String file_path){
    path = file_path;
  }

  public String[] OpenFile() throws IOException{
    FileReader fr = new FileReader(path);
    BufferedReader textReader = new BufferedReader(fr);
    
    int i;
    
    int textlisting = 12;
    String[] lines = new String[textlisting];
            
       for (i=0; i < lines.length; i++) {
          lines[i] = textReader.readLine();
          
       } 
    System.out.println(Arrays.toString(lines));
    
    return lines;
    }
    
  }
