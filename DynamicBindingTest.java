package session2;

public class DynamicBindingTest {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Car(); //upcasting
		Vehicle vehicle2 = new Vehicle();
		//Car car1 = (Car) new Vehicle(); //downcasting - this generates compile error
		Car car1 = (Car)vehicle1; //downcasting  - it is allowed as vehicle1 refers Car
		Car car2 = new Car();
		
		vehicle1.start();
		vehicle2.start();
		car1.start();
		car2.start();
	}

}

class Vehicle{
	public void start()
	{
		System.out.println("Inside start method of Vehicle");
	}
}

class Car extends Vehicle{
	@Override
	public void start() {
		System.out.println("Inside start method of Car");
	}
}