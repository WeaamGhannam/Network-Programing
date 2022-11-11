import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLHeader {

	public static void main(String[] args) throws IOException {
	URL u=new URL("https://www.google.ps/?gws_rd=ssl");
	URLConnection uc=u.openConnection();
	for(int i=0; ;i++) {
		String header= uc.getHeaderField(i);
	if (header==null) {
		break;
	}
	System.out.println(uc.getHeaderFieldKey(i)+""+header);
	}
	}
	}
//https://www.microsoft.com/
//https://twitter.com/i/flow/login
//https://www.google.ps/?gws_rd=ssl


