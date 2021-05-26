package facadePattern;

public class Iphone implements MobileShop {

	@Override
	public void modelNo() {
		System.out.println("Iphone10");
	}

	@Override
	public void price() {
		System.out.println("$ 1000.00");
	}
	
}
