import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class WordsInFiles {
   private Map<String,ArrayList<String>> mymap;
   public ArrayList<String> abb = new ArrayList<String>();
   WordsInFiles()
   {
       mymap = new HashMap<String,ArrayList<String>>();

   }

   private void addWordsFromFile(File f)
   {
       String filename = f.getName();
       FileResource fr = new FileResource(f);
       for(String line: fr.lines())
       {
          String word = "";
          for(int i = 0; i < line.length(); i++)
          {

              if(Character.isLetter(line.charAt(i)))
              {
                 word+=line.charAt(i);
              }
             else
             {
                 if(word.length() > 0)
                 {

                     if(mymap.containsKey(word))
                     {
                         if(mymap.get(word).indexOf(filename) == -1)
                         {
                             ArrayList<String> val = new ArrayList<String>();
                             val = mymap.get(word);
                             val.add(filename);
                             mymap.put(word,val);
                         }
                     }
                     else
                     {
                         ArrayList<String> val = new ArrayList<String>();
                         val.add(filename);
                         mymap.put(word,val);
                     }
                 }

                 word = "";
             }
          }

          if(word.length() > 0)
          {
              if(mymap.containsKey(word))
              {

                  if(mymap.get(word).indexOf(filename) == -1)
                  {
                      ArrayList<String> val = new ArrayList<String>();
                      val = mymap.get(word);
                      val.add(filename);
                      mymap.put(word,val);
                  }
              }
              else
              {
                  ArrayList<String> val = new ArrayList<String>();
                  val.add(filename);
                  mymap.put(word,val);
              }
          }
       }
   }

    void buildWordFileMap()
    {
        mymap.clear();
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles())
        {
            addWordsFromFile(f);
        }
    }

    int maxNumber()
    {
        int mxsofar = -1;
        for(String key : mymap.keySet())
        {
            mxsofar = Math.max(mxsofar,mymap.get(key).size());

        }

        return mxsofar;
    }

    ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String> words = new ArrayList<String>();

        for(String key : mymap.keySet())
        {
            if(mymap.get(key).size() == number)
            {
                words.add(key);
            }
        }

        return words;
    }
}
