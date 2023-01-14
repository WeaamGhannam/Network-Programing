import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
public class MultithreadingTCPServer {
	private static  ServerSocket sersock ;
	private static final int PORT=1234;
	public static void main(String[] args) {
	ArrayList <ClientHandler>threadList=new ArrayList<>();
		System.out.println("Connecting to Port ...");
		try {	
			sersock = new ServerSocket(PORT);//step1
		
		} catch (IOException e) {
			System.out.println("Unable to setup to port ...");
			System.exit(1);
		}	

		try {
			do {
				Socket client = sersock.accept();//step2
				System.out.println("\n New client accpeted...");
			   ClientHandler serverThread=new ClientHandler(client,threadList); 
			   threadList.add(serverThread);
			   serverThread.start();
			}while(true);
		} catch (IOException e) {
		System.out.println("Unable to accept Client");
		}
	}
}


	
