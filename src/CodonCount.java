import java.util.HashMap;
import java.util.Map;
import edu.duke.*;

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
                if(mymap.get(key) == null)
                {
                    mymap.put(key,1);
                }
                else
                {
                    mymap.put(key,mymap.get(key)+1);
                }
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
        System.out.println("Counts of codons between " + start + " and " + end + " inclusive are:");
        for(String key : mymap.keySet())
        {
            int value = mymap.get(key);
            if(value >= start && value <= end)
            {
               System.out.println(key + "  " + value);
            }
        }
    }

    void tester()
    {
        FileResource fr = new FileResource();

        for(String line : fr.lines())
        {
            line = line.toUpperCase();
            buildCodonMap(0 ,line);
            System.out.println("Reading frame starting with 0 results in " + mymap.size() + " unique codons");
            String mxoccur =  getMostCommonCodon();
            System.out.println(" and most common codon is " + mxoccur + " with count " + mymap.get(mxoccur));
            printCodonCounts(1,5);
            System.out.println();
            buildCodonMap(1,line);
            System.out.println("Reading frame starting with 1 results in " + mymap.size() + " unique codons");
            mxoccur =  getMostCommonCodon();
            System.out.println(" and most common codon is " + mxoccur + " with count " + mymap.get(mxoccur));
            printCodonCounts(1,5);
            System.out.println();
            buildCodonMap(2,line);
            System.out.println("Reading frame starting with 2 results in " + mymap.size() + " unique codons");
            mxoccur =  getMostCommonCodon();
            System.out.println(" and most common codon is " + mxoccur + " with count " + mymap.get(mxoccur));
            printCodonCounts(1,5);
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        CodonCount ob = new CodonCount();
        ob.tester();
    }
}