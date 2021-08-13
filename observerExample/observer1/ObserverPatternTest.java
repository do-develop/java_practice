package exercise6.observer1;

public class ObserverPatternTest {

	public static void main(String[] args) {
		// create subject
		TopicSubject topic = new TopicSubject();
		
		//create observers
		Observer obj1 = new SubscriberObserver("Subscriber1");
		Observer obj2 = new SubscriberObserver("Subscriber2");
		Observer obj3 = new SubscriberObserver("Subscriber3");

		//register observers to the subject
		topic.register(obj1);
		topic.register(obj2);
		topic.register(obj3);
		
		//attach observer to subject
		obj1.setSubject(topic);
		obj2.setSubject(topic);
		obj3.setSubject(topic);
		
		//check if any update is available
		obj1.update();
		
		//now send message to subject
		topic.postMessage("This is my new post message");
		
		obj1.update();
		obj2.update();
		obj3.update();
	}

}