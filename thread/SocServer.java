package ws10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocServer {

	public static void main(String[] args) throws IOException {
		Scanner kbInput = new Scanner(System.in);
		ServerSocket svcSock = new ServerSocket(2000); //random number other than 1-1024
	
		System.out.println("Going into waiting mode...");
		//wait for client to connect
		Socket sock = svcSock.accept(); 
		//Connected and as a result, new socket for communication is created
		//Set up the input/output streams
		PrintWriter writer =
				new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(sock.getOutputStream())),true);
		
		BufferedReader reader = 
				new BufferedReader(//read one line
					new InputStreamReader(sock.getInputStream())
					//byte to letter
				);
		
		while(true) {
			String inMesg = reader.readLine();
			System.out.println(inMesg);
			
			String outMesg = kbInput.nextLine();
			writer.println(outMesg);
			if(outMesg.length() == 0)
				break;
		}
		sock.close();	
	}

}
