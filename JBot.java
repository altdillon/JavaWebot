
import java.util.*;

public class JBot
{
    //factorys for parser and site classes  

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

  public static void main(String args[]) //test code
  {
    JBot bot=new JBot();
    Site server=bot.getSite("google.com");
    Parser parse=bot.getParser(server);
    //    server.cd("/pdf");
    ArrayList<String> links=parse.getLinks();  
    
    for(int i=0;i<links.size();i++)
        System.out.println(links.get(i));                                       

  }

}
