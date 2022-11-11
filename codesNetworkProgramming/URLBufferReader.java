import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLBufferReader {

	public static void main(String[] args) throws IOException {
		URL u= new URL("https://ptuk.edu.ps/ar/");
		URLConnection uc= u.openConnection();
		InputStream is= uc.getInputStream();
		InputStreamReader isr= new InputStreamReader(is);		
		BufferedReader br=new BufferedReader(isr);
      String s= br.readLine();
      while (s!=null) {
    	  System.out.println(s);
    	  s=br.readLine();
      }
      }
	}

