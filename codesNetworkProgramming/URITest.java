import java.net.URI;
import java.net.URISyntaxException;

public class URITest {

	public static void main(String[] args) throws URISyntaxException {
		URI uri=new URI("https://www.youtube.com/watch?v=3ROh23C2cvI#col=855");
		System.out.println("Scheme:"+ uri.getScheme());
		System.out.println("Authority:"+ uri.getAuthority());
		System.out.println("Path:"+uri.getPath());
		System.out.println("Query:"+uri.getQuery());
		System.out.println("Fragment:"+uri.getFragment());
		System.out.println("User Information:"+uri.getUserInfo());
		System.out.println("Port Number:"+uri.getPort());
	}

}

// https://Arnab_Kundu@www.geeksforgeeks.org
//https://www.youtube.com/watch?v=3ROh23C2cvI#col=855
//ftp://download.com/fileA.pdf
//telnet://192.168.10.20:80/
//mailto://me@fadclk.com/