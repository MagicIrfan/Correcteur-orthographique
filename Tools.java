import java.util.*;
public class Tools {
    
    public static Map<String, Integer> sortByValue(Map<String, Integer> hm, boolean ordered)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        if (!ordered)
            Collections.sort(list,(i1,i2) -> i2.getValue().compareTo(i1.getValue()));
        else
            Collections.sort(list,(i1,i2) -> i1.getValue().compareTo(i2.getValue()));
        
        Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    public static List<String> toTrigram(String word){
        List<String> trigrams = new ArrayList<String>();
        for(int index = 0; index<word.length() - 2; index++){
            String trigram = word.substring(index, index+3);
            trigrams.add(trigram);
        }
        return trigrams;
    }

    public static void addChevrons(List<String> dictionary){
        for(int i=0; i< dictionary.size(); i++){
            StringBuilder builder = new StringBuilder("<");
            dictionary.set(i,builder.append(dictionary.get(i)).append(">").toString());
        }

    }
}
