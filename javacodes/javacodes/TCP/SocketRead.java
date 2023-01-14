import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
public class SocketRead {
	public static void main(String[] args) throws IOException  {
	    String host="www.yahoo.com";
		Socket sc=new Socket(host,80);
		OutputStream os=sc.getOutputStream();
		boolean autoflash=true;
		PrintWriter out=new PrintWriter(os,autoflash);
		out.println("GET/HTTP/1.1");
		out.println("Host: "+host+":80");
		InputStream is =sc.getInputStream();
		InputStreamReader isr=new InputStreamReader(is);
		BufferedReader br=new BufferedReader(isr);
		StringBuilder sb= new StringBuilder(8192);
			int i=0;
				while(i!=-1) {
					i=br.read();
					sb.append((char)i);
	     }	
		System.out.println(sb.toString());
		sc.close();
		os.close();
	  }
    }

