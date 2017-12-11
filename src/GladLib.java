import java.util.*;
import edu.duke.*;
import java.io.*;
public class GladLib {
    private HashMap<String,ArrayList<String> >myMap;
    private Random myRandom;
    private static String dataSourceURL = "https://github.com/Anichur25/Array_List_Datastructure-new-/tree/master/Resources";
    private static String getDataSourceDirectory = "C:\\Users\\pc\\Downloads\\GladLibs";
    public GladLib(){
        myMap = new HashMap<>();
        myRandom = new Random();
        initializeFromSource(dataSourceURL);
    }
    public GladLib(String source){
        myMap = new HashMap<>();
        myRandom = new Random();
        initializeFromSource(source);
    }
    private ArrayList<String> readIt (String source){
        ArrayList<String> list = new ArrayList<>();

        if(source.startsWith("http")){
            URLResource urlResource = new URLResource(source);
            for(String line : urlResource.lines())
                list.add(line);
        }

        else{
            FileResource fileResource = new FileResource(source);
            for(String word : fileResource.lines())
                list.add(word);
        }

        return list;
    }
    private void initializeFromSource(String source){
        String[] category = {"adjective", "animal", "color", "country", "fruit", "name", "noun", "timeframe", "verb"};

        for(int i=0; i<9; i++)
            myMap.put(category[i], readIt(source + "/" + category[i] + ".txt"));
    }

}
