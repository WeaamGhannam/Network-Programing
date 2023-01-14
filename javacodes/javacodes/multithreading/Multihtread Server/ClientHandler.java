import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
public class ClientHandler extends Thread {
	private static Socket client;
	private  InputStream input;
	private  InputStreamReader isr;
	private  BufferedReader br;
    private PrintWriter output;
	private static ArrayList <ClientHandler>threadList=new ArrayList<>();
 	
public ClientHandler (Socket link,ArrayList <ClientHandler>threads) {
 		try {
			ClientHandler.client=link;
			ClientHandler.threadList=threads;
			//input=new Scanner(client.getInputStream());
			 input=client.getInputStream();//step2
			 isr=new InputStreamReader(input);
			 br=new BufferedReader(isr);
			 output =new PrintWriter (client.getOutputStream());
		} catch (IOException e) {
		System.out.println("no threads found");
		}
 	}
		public void run() {
	 		int numMessages=0;
	        String message="";
	        try {
	        do{
			message=br.readLine();//step4
			System.out.println("Message received.");
			numMessages++;		
			System.out.println("Message "+numMessages+":"+message);
			//output.println(message);
			printToAllClients(message);
			output.flush();
			}while (!message.equalsIgnoreCase("close"));
			System.out.println(numMessages+" Message received.");
	       
			} catch (IOException e) {
				System.out.println("Message Not recieved");
			}
			try {
				System.out.println("Closing Connection...");
				client.close();//step5
			} catch (IOException e) {
				System.out.println("Unable to close Socket");	
			}
 	}
		private void printToAllClients(String message){
			for (ClientHandler st:threadList) {
				st.output.println(message);
			}
		}
}
