import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
public class FTPClient {
	public static void main(String[] args) throws  IOException {
		Socket socket=new Socket("127.0.0.1",4000);
	    File file=new File("UploadFile.txt");
		InputStream in=new FileInputStream(file);
		OutputStream out=socket.getOutputStream();
		System.out.println("File Uploaded ");
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


