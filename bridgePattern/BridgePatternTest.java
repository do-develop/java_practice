package bridgePattern;

public class BridgePatternTest {

	public static void main(String[] args) {
		Shape triangle1 = new Triangle(new RedColor());
		Shape triangle2 = new Triangle(new GreenColor());
		Shape pentagon1 = new Pentagon(new RedColor());
		Shape pentagon2 = new Pentagon(new GreenColor());
		
		triangle1.applyColor();
		triangle2.applyColor();
		pentagon1.applyColor();
		pentagon2.applyColor();
	}

}
