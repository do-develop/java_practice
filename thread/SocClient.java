package ws10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SocClient {

	public static void main(String[] args) throws IOException {
		Scanner kbInput = new Scanner(System.in);
		InetAddress addr = InetAddress.getByName("localhost");
		
		//Attempt to connect now
		Socket sock = new Socket(addr, 2000);
		
		//Connected, set up input/output stream
		PrintWriter writer =
				new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(sock.getOutputStream())),true);
		
		BufferedReader reader = 
				new BufferedReader(
						new InputStreamReader(sock.getInputStream())
						);
		
		//Send the first message
		writer.println("I am a client. I am connected to the server!");
		//Go to the waiting mode for server response
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
