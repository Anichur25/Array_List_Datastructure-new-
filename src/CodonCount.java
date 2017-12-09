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

    String getMostCommonCodon()
    {
        String ans = "";
        int mxsofar = -1;

        for(String key : mymap.keySet())
        {
            if(mymap.get(key) > mxsofar)
            {
                mxsofar = mymap.get(key);
                ans = key;
            }
        }
        return ans;
    }

    void printCodonCounts(int start,int end)
    {
        for(String key : mymap.keySet())
        {
            int value = mymap.get(key);
            if(value >=start && value <=end)
            {
               System.out.println(key + "  " + value);
            }
        }
    }
}