package readdata;


public class DataSPT{

  Double hs = null;
  Double tz = null;
  Double battery = null;
  String path = null;
  String datetime = null;
  
  public DataSPT(String[] file_data, String path){
    
    hs = new Double(file_data[1]);
    tz = new Double(file_data[2]);
    battery = new Double(file_data[6]);
    
    String filename = path.substring(path.lastIndexOf("\\") + 1);
    
    datetime = filename.substring(0,filename.length()-4);
  }
}
