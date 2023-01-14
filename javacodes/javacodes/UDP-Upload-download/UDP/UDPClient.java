import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
public class UDPClient {
	private static InetAddress host;
	private static final int PORT = 6666;
	private static DatagramSocket clientsock;
	private static DatagramPacket incomPacket,outcomPacket;
	private static byte[] buffer;
	public static void main(String args[]) 
	{
		try {
			 host = InetAddress.getLocalHost();//step1
		} catch (UnknownHostException e) {
			System.out.println("Unable to find host");
			System.exit(1);
		}	
	
		serverAccessing();
		
	}
	
private static void serverAccessing() {
	try {
	clientsock = new DatagramSocket();//step2
	Scanner userEntry = new Scanner(System.in);//step3
	String message, response;
		do {
		  //take input and send the packet to server
		   System.out.print("Enter message: ");
		   message = userEntry.nextLine();//step3
		   System.out.println(message);
		   outcomPacket = new DatagramPacket(message.getBytes(),message.length(),host, PORT);//step4
		   clientsock.send(outcomPacket);//step5
		  //buffer to receive incoming data from server
		   buffer = new byte[1500];//step6
		   incomPacket = new DatagramPacket(buffer, buffer.length);//step7
	       clientsock.receive(incomPacket);//step8
		   response = new String(incomPacket.getData(), 0, incomPacket.getLength());//step9
		   System.out.println("\nServer resceive>"+response);
				}while(!message.equalsIgnoreCase("close"));
				userEntry.close();//step10
		} catch (SocketException e) {
			System.out.println("Unable to open Socket");	
		} catch (IOException e) {
			System.out.println("No response form server");
		}
		System.out.println("Close Socket ...");
		clientsock.close();//step10
	}
}