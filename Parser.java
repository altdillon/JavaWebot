  import java.net.*;
  import java.util.*;
  import java.io.*;

  public class Parser
  {
    private String html;

    public Parser(Site site)
    {
      ArrayList<String> list=site.getRawText();
      
      for(int i=0;i<list.size();i++)
      {
        html=html+list.get(i);
      }
      
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

    private String getLinkByName(String name)
    {
      return null;
    }
  
    public ArrayList<String> getLinks() //has not been tested with test page
    {
       ArrayList<String> links=new ArrayList<String>();
       String out[]=html.split("<a href=\"");
       int cut=0;       

       for(int i=0;i<out.length;i++)
       {
           cut=out[i].indexOf("\">");
           System.out.println(cut);
          
           if(cut>=1)
             out[i]=out[i].substring(0,cut);
       }

       for(int i=0;i<out.length;i++)
       {
          links.add(out[i]);
       }

       return links;
    }

    
    public ArrayList<String> getButtons()
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

    public void submit() //need to play with submit more in http over telnet
    {
      String out[]=html.split("input type=\"submit\"");
      
      for(int i=0;i<out.length;i++)
      {
          System.out.println(out[i]);
      }
    }

    public String toString()
    {
      return html;
    }

  }

