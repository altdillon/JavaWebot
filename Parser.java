  import java.net.*;
  import java.util.*;
  import java.io.*;
  import java.util.regex.*;

  public class Parser
  {
    private String html;
    private static Pattern href=Pattern.compile("<a[^>]*href=[\"'][^\"']*[\"'][^>]*>");

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

   

    private String getLinkByName(String name)
    {
      return null;
    }
  
    public ArrayList<String> getLinks() 
    {
       ArrayList<String> links=new ArrayList<String>();
       Scanner str=new Scanner(html);

       while(true)
       {
	 String s = str.findWithinHorizon(href, 0);
         if(s==null)
	     break;

         links.add(s);
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

