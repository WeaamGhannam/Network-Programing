import java.net.URI;
import java.net.URL;

public class URIToURL {
  public static void main(String[] args) throws Exception {

    URI uri = new URI("https://www.youtube.com/watch?v=3ROh23C2cvI#col=855");
    URL url = uri.toURL();
    System.out.println("Orignal URI: "+ uri);
    System.out.println("converted URL:"+url);
  }
}




