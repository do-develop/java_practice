package composite_pattern;

public class CompositePatternDemo {

	public static void main(String[] args) {
		Employee emp1 = new Cashier(100, "Star Butterfly", 20000.0);
		Employee emp2 = new Cashier(101, "Marco Polo", 20000.0);
		Employee emp3 = new Cashier(102, "Rick Sanchez", 20000.0);
		Employee emp4 = new Accountant(200, "Tom Lucifer", 20000.0);
		Employee emp5 = new Accountant(201, "Pony Head", 20000.0);
		Employee manager1 = new BankManager(300, "Jackie Lynn", 20000.0);

		manager1.add(emp1);
		manager1.add(emp2);
		manager1.add(emp3);
		manager1.add(emp4);
		manager1.add(emp5);
		
		//manager1.print();
		manager1.getChild(1).print();
		manager1.remove(emp2);
		manager1.getChild(1).print();
	}

}
