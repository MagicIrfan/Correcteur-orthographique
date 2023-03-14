import java.util.*;

public class App 
{
    public static void main(String [] args){
        List<String> fautes = new ArrayList<String>();
        List<String> dictionary = new ArrayList<String>();
        
        DataReader readerfautes = new DataReader(fautes, "fautes.txt");
        DataReader readerdico = new DataReader(dictionary, "dico.txt");
        long sum = 0;
        for(String i : fautes){
            Corrector corrector = new Corrector(i,dictionary);
            if(corrector.containsinDictionary(i))
                System.exit(0);
            long begin = System.nanoTime();
            System.out.println(corrector);
            long end = System.nanoTime();
            sum += (end - begin);
            
           
        }
        
        System.out.printf( "Temps : %f secondes", sum / 1e9 );
        
        


        
    }
}
