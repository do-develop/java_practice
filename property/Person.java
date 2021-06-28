package javafx_practice.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

	private StringProperty firstName = 
			new SimpleStringProperty(this, "firstName", "");

	//Returns the StringProperty objects
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);;
	}
	
	
	
}
