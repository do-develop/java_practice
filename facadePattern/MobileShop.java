package facadePattern;

/*
 * Advantage of Facade Pattern
It shields the clients from the complexities of the sub-system components.
It promotes loose coupling between subsystems and its clients.
Usage of Facade Pattern:
It is used:
	When you want to provide simple interface to a complex sub-system.
	When several dependencies exist between clients and the implementation 
	classes of an abstraction.
 */
public interface MobileShop {

	public void modelNo();
	public void price();
}
