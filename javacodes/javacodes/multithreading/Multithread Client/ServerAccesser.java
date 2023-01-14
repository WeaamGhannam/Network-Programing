import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
public class ServerAccesser extends Thread {
	private static Socket client;
	private static InputStream input;
	private static InputStreamReader isr;
	private static BufferedReader br;
	private static PrintWriter output;
	private static Scanner userEntry;
	public ServerAccesser (Socket link) {
 		try {
 			ServerAccesser.client=link;
			//input=new Scanner(client.getInputStream());
 			 userEntry = new Scanner(System.in);
 			input=client.getInputStream();
			 isr=new InputStreamReader(input);
			 br=new BufferedReader(isr);
		    output =new PrintWriter (client.getOutputStream());
		} catch (IOException e) {
			System.out.println("Message not sent from user");
		}
 	}
	
	public void run() {
	 String message, response;
			System.out.println("Connected...");
	         try {
				do {
					System.out.print("Enter Message: ");
					message=userEntry.nextLine();
					System.out.println(message);
					output.println(message);
					output.flush();
					response=br.readLine();
					System.out.println("\nServer resceive>"+response);
					}while (!message.equalsIgnoreCase("close"));
					userEntry.close();
					br.close();
				    output.close();
			} catch (IOException e) {
				System.out.println("No response form server" );
			}			
	      try {
	    	  System.out.println("Close Connection...");
	    	 
	    	  client.close();//step4  
		} 
	      catch (IOException e) {
			System.out.println("Unable to connect");
			System.exit(1);

		}			
		}	
}
