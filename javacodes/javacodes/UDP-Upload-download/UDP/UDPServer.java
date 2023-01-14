import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPServer {
	private static final int PORT=6666;
	private static DatagramSocket sock ;
	private static DatagramPacket incomPacket,outcomPacket;
	private static byte[] buffer;
	public static void main(String args[]) 
	{
		
	try {
		//1. creating a server socket, parameter is local port number
		System.out.println("Opening Port ...");
		sock = new DatagramSocket(PORT);//step1
		clientHandling();
		} catch (IOException e) {
			System.out.println("Unable to attach port");
			System.exit(1);
		}	
	}	
	private static void clientHandling() {
		String messageIn, messageOut;//step2
		int numMessages=0;
		try {
			do {
			//buffer to receive incoming data from client
			buffer = new byte[1500];//step2
			incomPacket = new DatagramPacket(buffer, buffer.length);//step3
			sock.receive(incomPacket);//step4
			messageIn = new String(incomPacket.getData(), 0, incomPacket.getLength());//step5
			System.out.println("Message recieved.");
			numMessages++;
			messageOut="message"+numMessages+":"+messageIn;
			System.out.println(messageOut);
			//take input and send the packet to client
			InetAddress host=incomPacket.getAddress();//step6
			int cliPort=incomPacket.getPort();//step6
			outcomPacket= new DatagramPacket(messageOut.getBytes(),messageOut.length(),host,cliPort);//step7
			sock.send(outcomPacket);//step8
			
			}while(true);
			
		} catch (IOException e) {
			System.out.println("Message not Recieved");
			System.exit(1);
		}	
	
	//sock.close();

	}
	
}
