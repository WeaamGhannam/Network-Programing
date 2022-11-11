
import java.io.File;
import java.net.URI;
import java.net.URL;
public class FileToURI {
  public static void main(String[] argv) throws Exception {
    File f = new File("test4444.txt");

    URI uri = f.toURI();
    URL url = uri.toURL();
    System.out.println("Orignal file: "+ f);
    System.out.println("converted URI:"+uri);
    System.out.println("converted URL:"+url);
  }
}


