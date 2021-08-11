package strategy_pattern;

public class StrategyPatternDemo {

	public static void main(String[] args) {
		Context context = new Context(new OperationAdd());
		System.out.println("2 + 5 = " + context.executeStrategy(2, 5));
		
		context = new Context(new OperationSubtract());
		System.out.println("2 - 5 = " + context.executeStrategy(2, 5));
		
		context = new Context(new OperationMultiply());
		System.out.println("2 * 5 = " + context.executeStrategy(2, 5));

	}

}
