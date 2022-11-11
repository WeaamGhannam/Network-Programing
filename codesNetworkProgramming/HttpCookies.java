import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
public class HttpCookies {

	public static void main(String[] args) throws IOException {
		
		//URL url = new URL("http://127.0.0.1:80");
	   //  URLConnection conn = url.openConnection();
	   //  conn.setRequestProperty("Cookie", "name1=value1; name2=value2");
	  //   conn.connect();

		URL url = new URL("https://www.google.ps/?gws_rd=ssl");
	    URLConnection conn = url.openConnection();

	    for (int i = 0;; i++) {
	      String headerName = conn.getHeaderFieldKey(i);
	      String headerValue = conn.getHeaderField(i);
	      
	      if (headerName == null && headerValue == null) {
	        break;
	      }
	      if ("Set-Cookie".equalsIgnoreCase(headerName)) {
	    	 
	        String[] fields = headerValue.split(";\\s*");
	      
	        // Set-CookieAEC=AakniGOxK9N0CPF_JF48-M4yRYYbJUWSmpE-gAexEGDSKH0zDs2mY8Hjgg; 
	      //  expires=Mon, 17-Apr-2023 07:03:51 GMT; 
	     //   path=/; 
	      //  domain=.google.ps;
	      //  Secure; 
	      //  HttpOnly; 
	     //   SameSite=lax
	        		
	        for (int j = 1; j < fields.length; j++) {
	          if ("secure".equalsIgnoreCase(fields[j])) {
	            System.out.println("secure=true");
	          } else if (fields[j].indexOf('=') > 0) {
	            String[] f = fields[j].split("=");
	            if ("expires".equalsIgnoreCase(f[0])) {
	              System.out.println("expires"+ f[1]);
	            } else if ("domain".equalsIgnoreCase(f[0])) {
	              System.out.println("domain"+ f[1]);
	            } else if ("path".equalsIgnoreCase(f[0])) {
	              System.out.println("path"+ f[1]);
	            }
	          }
	        }
	      }
	    }
	    
	}

}
