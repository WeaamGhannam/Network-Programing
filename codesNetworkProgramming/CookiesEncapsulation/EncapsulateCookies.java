import java.net.URLConnection;


public class EncapsulateCookies {
	private static String headerName;
	private static String headerValue;
    public static URLConnection encapcookies(URLConnection uc) {
    	
		 for (int i=0; ;i++) {
	    headerName=uc.getHeaderFieldKey(i);
		 headerValue=uc.getHeaderField(i);
			if (headerName==null && headerValue==null) {
				break;
			}
			if("Set-Cookie".equalsIgnoreCase(headerName)) {
			System.out.println(headerName);
				String [] fields=headerValue.split(";//s*");
				for (int j=0;j<fields.length;j++) {
					if ("Secure".equalsIgnoreCase(fields[j])) {
						System.out.println("Secure=true");
					}
					else if(fields[j].indexOf("=")>0){
						System.out.println(headerValue);	
					}
				}
			}

		 }
		return uc;
}
}