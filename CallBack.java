package sample;

public class CallBack {

	public static void main(String[] args) {
		Callee callee = new Callee();
		callee.setCallback(new Callee.CallBack() {
			@Override
			public void onGetMessage(Callee callee) { //upon user input, this will be executed
				System.out.println("Entered message: " + callee.getMessage());
			}
		});

		callee.getInputMessage();
	}

}
