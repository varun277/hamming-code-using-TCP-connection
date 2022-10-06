import java.net.*;
import java.io.*;

class hamServer
{
	public static void main(String args[]) throws Exception{
	
	System.out.println("Server Starting....");
	ServerSocket ss = new ServerSocket(1234);
	System.out.println("Server initialized...");
	Socket s = ss.accept();
	System.out.println("Client Connected...");
	DataInputStream din = new DataInputStream(s.getInputStream());	
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int i,len,c=0;
	String str1 = "",str2="",str3 ="";
	str1 = din.readUTF();
	str2 = din.readUTF();
	len = str1.length();
	for(i =0;i<len;i++){
		if(str1.charAt(i)!=str2.charAt(i))
		{
		  c = c+1;
		}
	}
	str3 = String.valueOf(c);
	dout.writeUTF(str3);
	dout.flush();
	s.close();
	ss.close();
	System.out.println("Server Disconnected.....");
	}


}