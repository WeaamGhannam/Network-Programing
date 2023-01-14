import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
public class MultithreadingTCPClient {
private static InetAddress host;
private static final int PORT=1234;
private static Socket client = null;
//	private static final String host;
public static void main(String args[]) {
try {
	 host = InetAddress.getLocalHost();
	client = new Socket (host,PORT);//step1	
	 ServerAccesser clientThread=new ServerAccesser(client);
	 clientThread.start();
} catch (IOException e) {
	System.out.println("Host not Found");
	System.exit(1);
}
}

	}