import java.net.*;
import java.io.*;

class hamClient
{
	public static void main(String args[]) throws Exception{
	
	System.out.println("connecting to server....");
	
	Socket s = new Socket("localhost",1234);
	System.out.println("connected to server....");
	
	DataInputStream din = new DataInputStream(s.getInputStream());	
	DataOutputStream dout = new DataOutputStream(s.getOutputStream());
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String str1 = "",str2="",str3="";
	System.out.println("Enter string 1:");
	str1= br.readLine();
	dout.writeUTF(str1);
	dout.flush();
	System.out.println("Enter string 2:");
	str2= br.readLine();
	dout.writeUTF(str2);
	dout.flush();
	
		
	str3 = din.readUTF();
	System.out.println("Hamming Distance :"+str3);
		
		
	s.close();
	System.out.println("Server Disconnected.....");
	}


}