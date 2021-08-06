//setters with validation

public class Baby {
	private String name;
	private int age;
	
	//default constructor
	public Baby() {
		name = "none";
		age = 0;
	}
	
	public Baby(String name, int age) {
		//if the name is valid set the argument name as the name of this object.
		//if not, the name will be set as "none"
		if(isValidName(name)) {
			this.name = name;
		}else {
			this.name = "none";
		}
		//check validity of the passed value before setting the age.
		//if not, the default age is 0.
		if(age>=1 && age<=5) {
			this.age = age;
		}else {
			this.age = 0;
		}
	}
	
	public void setName(String name) {
		if(isValidName(name)) {
			this.name = name;
		}else {
			this.name = "none";
		}
	}
	
	public void setAge(int age) {
		if(age>=1 && age<=5) {
			this.age = age;
		}else {
			this.age = 0;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	//if the name and age of the two objects are the same, it is considered as the same baby.
	public boolean sameBaby(Baby baby) {
		return (name.equalsIgnoreCase(baby.getName())&&age==baby.getAge());
	}
	
	//helper method to check the validity of name input
	//no white space or empty string allowed
	private boolean isValidName(String name) {
		return (name.contains(" ")||name.isEmpty());
	}
}
