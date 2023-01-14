import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class FTPClient {
	public static void main(String[] args) throws  IOException {
		Socket socket=new Socket("127.0.0.1",4000);
		InputStream in=socket.getInputStream();
		OutputStream out=new FileOutputStream("mah.txt");
		System.out.println("recieved File ");
		byte []b=new byte[20*1024];
		int i;
		while((i=in.read(b))>0) {
			out.write(b,0, i);
		}
	out.close();
	in.close();
	socket.close();
	}
         
	}


