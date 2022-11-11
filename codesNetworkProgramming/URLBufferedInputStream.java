import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLBufferedInputStream {

	public static void main(String[] args) throws IOException {
		URL u=new URL("https://ptuk.edu.ps/ar/");
		URLConnection uc=u.openConnection();
		InputStream is=uc.getInputStream();
		BufferedInputStream buf=new BufferedInputStream(is);
		int i=0;
		char c;
		while((i=buf.read())!=-1) {
			c=(char)i;
			System.out.print(c);
		}
	}
	
	

	
}