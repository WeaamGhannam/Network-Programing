import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class FTPServer {
	public static void main(String[] args) throws IOException {
		ServerSocket ssc=new ServerSocket(4000);//  
		System.out.println("listen to client connection");
		Socket socket=ssc.accept();
        File file=new File("mah.txt");
		InputStream in=new FileInputStream(file);
		OutputStream out=socket.getOutputStream();
		byte []b=new byte[20*1024];
		int i;
		while((i=in.read(b))>0) {
			out.write(b,0, i);
		}
	out.close();
	in.close();
	socket.close();
	ssc.close();
	}
}
