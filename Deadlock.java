package session5;

public class Deadlock {

	static class Friend{
		private final String name;
		public Friend(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public synchronized void bow(Friend bower) {
			System.out.printf("%s: %s" + 
					" has bowed to me\n", name, bower.getName());
			bower.bowBack(this);
		}
		//bowback does not occur due to deadlock
		public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                + " has bowed back to me!%n", name, bower.getName());
        }
	}
	public static void main(String[] args) {
		final Friend juno = new Friend("Juno");
		final Friend magie = new Friend("Magie");
		
		new Thread(new Runnable() {
			public void run() {
				juno.bow(magie);
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				magie.bow(juno);
			}
		}).start();
		
	}

}
