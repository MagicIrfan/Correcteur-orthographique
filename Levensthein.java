public class Levensthein {

    static int minimum(int a, int b, int c) 
    {                            
        return Math.min(Math.min(a, b), c);                                      
    }   

    static int value(String left, String right)
    {
        int leftsize = left.length();
        int rightsize = right.length();

        int[][] distance = new int[leftsize + 1][rightsize + 1];        
                                                                                 
        for (int i = 0; i <= leftsize; i++)                                 
            distance[i][0] = i;                                                  
        for (int j = 1; j <= rightsize; j++)                                 
            distance[0][j] = j;                                                  

        for (int i = 1; i <= leftsize; i++){                      
            for (int j = 1; j <= rightsize; j++){                          
                distance[i][j] = minimum(                                        
                        distance[i - 1][j] + 1,                                  
                        distance[i][j - 1] + 1,                                  
                        distance[i - 1][j - 1] + ((left.charAt(i-1) == right.charAt(j-1)) ? 0 : 1));
            }
        }
                                                                                 
        return distance[leftsize][rightsize]; 
    }
}
