package facadePattern;

public class Samsung implements MobileShop{

	@Override
	public void modelNo() {
		System.out.println("Samsung galaxy note 10");
	}

	@Override
	public void price() {
		System.out.println("$ 1100.00");
	}
	

}
