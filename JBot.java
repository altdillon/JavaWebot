import java.io.*;
import java.util.*;
import java.net.*;

public class JBot
{
  
  public Parser getParser(Site site)
  {
    return (new Parser(site));
  } 

  public Site getSite(String url)
  {
    return (new Site(url));
  }

  public Site getSite(String url,String qurey)
  {
    return (new Site(url,qurey));
  }

  class SSLsite extends Site
  {
    public SSLsite(String url)
    {
      super(url);
    }

    public void getSite(String qurey)
    {

    }


  }



  class Site
  {
    private String url;
    private String qurey;
    private String path="/";
    private String version="HTTP/1.0";
    private Socket connection;
    private Scanner in;
    private PrintWriter out;
    private ArrayList<String> lines=new ArrayList<String>();

    /**
     * @param string url for target website
     *
     */

    public Site(String url)
    {
      this.url=url;
      qurey="GET "+path+' '+version;
      getSite(qurey);
    }

    /**
     * @param string value for url website
     * @param string for http qurey
     */

    public Site(String url,String qurey)
    {
      this.url=url;
      this.qurey=qurey;
      getSite(qurey);
    }
   
    /**
     * setter for http version
     * @param string value for version
     */

    public void setVersion(String ver)
    {
      version=ver;
    }

    /**
     * opens the socket and the tcp input and output for talking to web servers
     */

    private void open()
    {
      lines=new ArrayList<String>();
      try
      {
         connection=new Socket(url,80);
         out=new PrintWriter(connection.getOutputStream(), true);
         in=new Scanner(new InputStreamReader(connection.getInputStream()));
      }
      catch(IOException e)
      {
        System.out.println(e);
      }
    }
 
    /**
     * downloads the raw html + http codes for the websites 
     * @param string value for the qurey
     */

    public void getSite(String qurey)
    {
      open();
      out.println(qurey);
      out.println(); 
      String buffer=null;      
      int index=0;

      while(in.hasNext())
      {
        buffer=in.nextLine();
        if(buffer.equals("0"))
            break;
        else
        {
          lines.add(buffer);
        }
      }
   
    }

    /**
     * changes the directory to the next higher directory in the tree some what like unix cd
     * @param string value for next folder
     * @return boolean to see if the directory works
     */

    public boolean cd(String dir)
    {
      boolean diditwork=false;
      open();
      path=dir+'/'; 
      qurey="HEAD /"+dir+"/ "+version;
      out.println(qurey);
      out.println();
 
      if(in.nextLine().equals("HTTP/1.1 200 OK"))
          diditwork=true;

      qurey="GET /"+dir+"/ "+version;
      getSite(qurey);

      return diditwork;
    }

    /**
     * submits data for html/http fourms 
     * @param string text data to submit
     * @param string location of the id of the fourm
     * @return returns true if the submission worked
     */

    public boolean submit(String data,String resorce)
    {
      open();
      boolean out=false;
       
      return out;
    } 

    /**
     * getter for the raw text of a website
     * @return arraylist of strings 
     */

    public ArrayList<String> getRawText()
    {
      return lines;
    }

    /**
     * getter for the http codes
     * @return an arraylist of strings of the arraylist
     */

    public ArrayList<String> getHttpCodes()
    {
      ArrayList<String> text=getRawText();
      ArrayList<String> codes=new ArrayList<String>();

      for(int i=0;i<4;i++)
           codes.add(text.get(i));
        
      return codes;
    }

  }




  class Parser
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
    }

  }


  public static void main(String args[]) //test code
  {
    JBot bot=new JBot();
    Site server=bot.getSite("192.168.1.100");
    Parser parse=bot.getParser(server);
    ArrayList<String> links=parse.getLinks();  
    
    for(int i=0;i<links.size();i++)
        System.out.println(links.get(i));                                       

  }

}
