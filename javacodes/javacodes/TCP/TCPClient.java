import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class TCPClient{
private static InetAddress host;
private static final int PORT=1234;
//	private static final String host;
public static void main(String args[]) {
try {
	 host = InetAddress.getLocalHost();
	accessServer();
} catch (IOException e) {
	System.out.println("Host not Found");
	System.exit(1);
}
}
	private static void accessServer()  {
		System.out.println("Connected...");
		Socket link=null;//step1
		try {
			link = new Socket (host,PORT);//step1
			Scanner userEntry = new Scanner(System.in);//step2
				InputStream input=link.getInputStream();//step2
				InputStreamReader isr=new InputStreamReader(input);
				BufferedReader br=new BufferedReader(isr);
				PrintWriter output = new PrintWriter(link.getOutputStream());
				String message, response;	

			do {
				System.out.print("Enter Message: ");
				message=userEntry.nextLine();//step3
				System.out.println(message);
				output.println(message);
				output.flush();
				response=br.readLine();
				System.out.println("\nServer resceive>"+response);
				}while (!message.equalsIgnoreCase("close"));
				userEntry.close();//step4
				br.close();//step4
			    output.close();
		} catch (IOException e) {
			System.out.println("No response form server" );
		}			
      try {
    	  System.out.println("Close Connection...");
    	 
    	  link.close();//step4  
	} 
      catch (IOException e) {
		System.out.println("Unable to connect");
		System.exit(1);

	}			
	}	
	}
	

