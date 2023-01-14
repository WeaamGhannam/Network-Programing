import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Scanner;
public class TCPServer
{
//initialize socket and input stream
private static  ServerSocket sersock ;
private static final int PORT=1234;
public static void main(String args[])
{
	System.out.println("Connecting to Port ...");
	System.out.println("Server started...");
	System.out.println("Waiting for a client ...");
	try {	
		sersock = new ServerSocket(PORT);//step1
	
	} catch (IOException e) {
		System.out.println("Unable to connect to port ...");
		System.exit(1);
	}
	do {
		handleClient();
	}while(true);
}
	private static void handleClient() {
		Socket link=null;//step2
		try
		{
		link = sersock.accept();//step2
		System.out.println("Client accepted...");
		// takes input from the client socket
		InputStream input=link.getInputStream();//step3
		InputStreamReader isr=new InputStreamReader(input);//step3
     	BufferedReader br=new BufferedReader(isr);
     	PrintWriter output =new PrintWriter (link.getOutputStream(),true);
			int numMessages=0;
            String message=null;
			do{
			message=br.readLine();//step4
			System.out.println("Message received.");
			numMessages++;		
			System.out.println("Message "+numMessages+":"+message);
			output.println(message);
			}while (!message.equalsIgnoreCase("close"));
			System.out.println(numMessages+" Message received.");
			br.close();//step5
			output.close();//step5
		}
		catch(IOException i)
		{
			System.out.println("massege not received");
			System.exit(1);
		}
		try {
			// close connection
			System.out.println("Closing Connection...");
			link.close();//step5
			
		}catch (IOException e) {			
		System.out.println("Unable to close");
			System.exit(1);
		}
		
	}}



