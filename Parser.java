  import java.net.*;
  import java.util.*;
  import java.io.*;

  public class Parser
  {
    private String html;

    public Parser(Site site)
    {
      website=site;
      ArrayList<String> list=site.getRawText();
      
      for(int i=0;i<list.size();i++)
      {
        //code for adding crap to html string
      }
      
    }
    
    public Parser()
    {
      throw new Exception("site object needed before some one dies, I mean it!");
    }
    
    public String return_between(String str,String key,boolean include)
    {
      return null;
    } 

    /**
     * returns an array list of strings containg the url of links
     * @return an arraylist of links
     */
/*
    public ArrayList<String> getLinks() 
    {
      ArrayList<String> rawtext=website.getRawText(); // website class no longer used     
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
  */
  
    public ArrayList<String> getLinks()
    {
      
    }
  
    public ArrayList<String> getResorce_regex(String html_resorce) //use pattern class for getting links with regex
    {
      return null;
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


  }

