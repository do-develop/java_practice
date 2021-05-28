package builderPattern;

//The builder class, UserBuilder will help building desired object, User
//with all required attributes an combination of optional attributes
//without loosing the immutability

public class User {

	private final String firstName; //required
	private final String lastName; //required
	private final int age; //optional
	private final String phone; //optional
	private final String address; //optional
	
	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
	}
	
	//only getters and no setters to provide immutability
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
	
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
    
    //Builder class
    public static class UserBuilder
    {
    	private final String firstName;
    	private final String lastName;
    	private int age;
    	private String phone;
    	private String address;
    	
    	//the requires attributes will be implemented in builder constructor
    	public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    	
    	public UserBuilder age(int age) {
    		this.age = age;
    		return this;
    	}
    	
    	public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
    	
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        //Returns the constructed User object
        public User build() {
        	User user = new User(this);
        	validateUserObject(user);
        	return user;
        }
        
        private void validateUserObject(User user) {
        	//do some basic validations
        	if(user.getAge() < 0) {
        		System.out.println("Invalid age!");
        	}
        }
    }
}
