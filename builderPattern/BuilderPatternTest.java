package builderPattern;

public class BuilderPatternTest {

	public static void main(String[] args) {
		User user1 = new User.UserBuilder("Bart", "Simpson")
				.age(30)
				.phone("1234567")
				.address("Fake st. Fake city 54321")
				.build();
		
		System.out.println(user1);
		
		User user2 = new User.UserBuilder("Lisa", "Simpson")
				.age(28)
				.phone("2345678")
				//simulate no address this time
				.build();
		System.out.println(user2);
		
		User user3 = new User.UserBuilder("Marge", "Simpson")
				//simulate no other optional attributes
				.build();
		System.out.println(user3);
		
	}

}
