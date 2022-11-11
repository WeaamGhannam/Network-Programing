import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
/*from  j  av  a  2 s. co m*/
public class SocketThread extends Thread {
  public void run() {
    try {
      Socket socket = new Socket("127.0.0.1", 6666);

      DataInputStream in = new DataInputStream(socket.getInputStream());
      BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      while (true) {
        System.out.print("Enter response: ");
        String response = console.readLine();
        out.writeUTF(response);

        String message = in.readUTF();
        System.out.println(message);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Thread t = new SocketThread();
    t.start();
  }
}