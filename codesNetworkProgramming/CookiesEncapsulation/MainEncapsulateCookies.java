import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
public class MainEncapsulateCookies {
	public static void main(String[] args) throws IOException {
		URL u=new URL("https://www.linkedin.com/feed/");
		URLConnection uc =u.openConnection();
		EncapsulateCookies.encapcookies(uc);
   System.out.println("Unrechable!!!");
	}

}
