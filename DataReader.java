import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.*;

public class DataReader
{
    public DataReader(List<String> dictionary, String fileName){

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              dictionary.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
    
}