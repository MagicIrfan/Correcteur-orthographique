import java.util.*;

public class Corrector {
    List<String> dictionary;
    String wordtocompare;


    public Corrector(String wordtocompare, List<String> dictionary)
    {
        this.dictionary = dictionary;
        this.wordtocompare = wordtocompare;
        
    }

    public boolean containsinDictionary(String word)
    {
        return dictionary.contains(word);
    }

    public List<String> trigrams(String word){
        return Tools.toTrigram(word);
    }


    public Map<String,List<String>> addTrigram(){
        Map<String,List<String>> map = new HashMap<String,List<String>>();
        for(String trig : trigrams(wordtocompare)){
            map.put(trig,new ArrayList<String>());
            for(String element : dictionary){    
                if(element.contains(trig))
                    map.get(trig).add(element);
                    
            }
        }
        return map;
    }


    //liste de mots L qui ont au moins un trigramme commun avec M
    public List<String> mots(){
        List<String> mots = new ArrayList<String>();
        Map<String,List<String>> map = addTrigram();
        for(List<String> list : map.values()){
            mots.addAll(list);
        }
        Collections.sort(mots);
        return mots;
    }

    //Clé = L Valeur = Nombre d'occurences dans les listes de mots associés aux trigrammes de N
    public Map<String,Integer> occurences(){
        Map<String,List<String>> map = addTrigram();
        Map<String,Integer> maps = new HashMap<String,Integer>();
        List<String> words = mots();
        for(String word : words){
            maps.put(word, 0);
        }

        for(List<String> list : map.values()){
            for(String word : list){
                if(maps.containsKey(word))
                {
                    Integer value = maps.get(word) + 1;
                    maps.put(word,value);
                }
            }
        }
        maps = Tools.sortByValue(maps, false);
        return maps;
    }



    public List<String> trigramInCommuns(){
        Map<String,Integer> maps = occurences();
        return new ArrayList<String>(maps.keySet()).subList(0, maps.keySet().size() < 100 ? maps.keySet().size() : 100);

    }



    public List<String> sortByDistanceEdition(String word){
        List<String> list = trigramInCommuns();
        Map<String,Integer> maps = new HashMap<String,Integer>();
        for(String str : list){
            //Levensthein lev = new Levensthein();
            maps.put(str,Levensthein.value(word, str));
        }
        maps = Tools.sortByValue(maps, true);
        return new ArrayList<String>(maps.keySet()).subList(0, 5);

    }

    public String toString(){
        return wordtocompare + " : " + sortByDistanceEdition(wordtocompare);
    }


   
}
