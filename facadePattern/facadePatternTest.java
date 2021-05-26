package facadePattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class facadePatternTest {

	private static int choice=-1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		while(choice != 0) {
			System.out.println("FACADE PATTERN EXAMPLE - MOBILE SHOP");
			System.out.println("[1] IPhone");
			System.out.println("[2] Samsung");
			System.out.println("[3] Blackberry");
			System.out.print("Enter your choice(0 to end): ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			ShopKeeper sk = new ShopKeeper();
			
			switch(choice) {
			case 1:
				sk.iphoneSale();
				break;
				
			case 2:
				sk.samsungSale();
				break;
				
			case 3:
				sk.blackberrySale();
				break;
				
			default:
				System.out.println("No purchase");
			}
		} 

	}

}
