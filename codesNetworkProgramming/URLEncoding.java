import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLEncoder;
import java.net.URLDecoder;

 class QueryString
{
	private StringBuilder query = new StringBuilder();
	
	public QueryString()
	{
		
	}
	public synchronized void add(String name, String value) {
		query.append('&');
		encode(name, value);
		}
	
	
	private synchronized void encode(String name, String value) {
		try {
		query.append(URLEncoder.encode(name, "UTF-8"));
		query.append('=');
		query.append(URLEncoder.encode(value, "UTF-8"));
		} catch (UnsupportedEncodingException ex) {
		throw new RuntimeException("Broken VM does not support UTF-8");
		}
		}
	
	public synchronized String getQuery() {
		return query.toString();
		}
	
		@Override
		public String toString() {
		return getQuery();
		}
		
	

}


public class URLEncoding {

	public static void main(String[] args) throws IOException {
		
		QueryString qs = new QueryString();
		qs.add("hl", "en");
		qs.add("as_q", "Java");
		qs.add("as_epq", "I/O");
		qs.add("coursename","Network programming");
		String url = "http://www.google.com/search?" + qs;
		System.out.println(url);
		

	//	String s="https://www.google.com/search?hl=en&as_q=Java&as_epq=I/O";
		
      //  String sd= URLEncoder.encode(s,"UTF-8");
       // System.out.println("Original text: "+s);
     //   System.out.println("Encoded text: "+sd);
		
		/***************** here to encode each part not the whole URL *************/
		
		//String url = "https://www.google.com/search?";
		
	//	url += URLEncoder.encode("hl", "UTF-8");
	//	url += "=";
	//	url += URLEncoder.encode("en", "UTF-8");
	//	url += "&";
	//	url += URLEncoder.encode("as_q", "UTF-8");
	//	url += "=";
	//	url += URLEncoder.encode("Java", "UTF-8");
	//	url += "&";
	//	url += URLEncoder.encode("as_epq", "UTF-8");
	//	url += "=";
	//	url += URLEncoder.encode("I/O", "UTF-8");
		
		//System.out.println("Partially Encoded text: "+url);
		
		/********Decoding URL********************/
		String s="http%3A%2F%2Fwww.google.com%2Fnetwork%2B%3Fprogramming%2Fopen%23file";
        String sd= URLDecoder.decode(s, "UTF-8");
      ///  System.out.println(s);
      //  System.out.println(sd);
        
	}

}


// https://www.google.com/search?hl=en&as_q=Java&as_epq=I/O