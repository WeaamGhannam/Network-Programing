import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
public class URLInfo {

	public static void main(String[] args) throws IOException {
		URL url=new URL("https://ritaj.birzeit.edu/register/");
		URLConnection c=url.openConnection();
		
		 System.out.println("Content Type: "+ c.getContentType());
		 System.out.println("Content Encoding: "+ c.getContentEncoding());
		 System.out.println("Content Length: "+ c.getContentLength());
		 System.out.println("Date: "+ new Date (c.getDate()));
		 System.out.println("Last Modified : "+ new Date(c.getLastModified()));
		 System.out.println("Expiration: "+ new Date(c.getExpiration())); 
		 
		HttpURLConnection h=(HttpURLConnection) c;
		System.out.println("Request Massage: "+ h.getRequestMethod());
		System.out.println("Response Massage: "+ h.getResponseMessage());
		System.out.println("Request Code: "+ h.getResponseCode());
		System.out.println("Time out: "+ h.getReadTimeout());
		}
	}

