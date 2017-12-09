import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class CodonCount {
    private static Map<String,Integer> mymap;

    CodonCount()
    {
        mymap = new HashMap<String, Integer>();
    }

    void buildCodonMap(int start,String dna)
    {
        mymap.clear();
        dna = dna.trim();
        String key = "";
        for(int i = start; i < dna.length(); i++)
        {
            key+=dna.charAt(i);
            if(key.length() == 3)
            {
                mymap.put(key,mymap.get(key)+1);
                key = "";
            }
        }
    }

    
}