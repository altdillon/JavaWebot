  import java.net.*;
  import java.util.*;
  import java.io.*;

  public class Parser
  {
    private Site website;


    public Parser(Site site)
    {
      website=site;
    }
    
    public String return_between(String str,String key,boolean include)
    {
      return null;
    } 

    /**
     * returns an array list of strings containg the url of links
     * @return an arraylist of links
     */

    public ArrayList<String> getLinks()
    {
      ArrayList<String> rawtext=website.getRawText();     
      ArrayList<String> out=new ArrayList<String>();

      for(int i=0;i<rawtext.size();i++)
      {
        int start=rawtext.get(i).indexOf("href=\"");
        int stop=rawtext.get(i).indexOf("\">");      

        if(start>0 && stop>0)
        {
          String link=rawtext.get(i).substring((start+6),stop);
          out.add(link);
        } 

      }

      return out;
    }      
   
    public ArrayList<String> getTextInput()
    {
      return null;
    }

    public ArrayList<String> getTextBox()
    {
      return null;
    }
   
    public ArrayList<String> getRadioButtons()
    {
      return null;
    }

    private ArrayList<String> preParse(ArrayList<String> text,String tag)
    {
      String buffer="";
      int breakpoint=0;
      ArrayList<String> out=new ArrayList<String>();
      for(int i=0;i<text.size();i++)
      {
        
      }
     return out;     
   }

  }

