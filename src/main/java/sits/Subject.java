package sits;

import java.util.ArrayList;

public abstract class Subject {
	
	ArrayList<Observer> listeners;
	
	public void register(Observer listener) {
		listeners.add(listener);
		listener.subject = this;
	}
	
	public void deregister(Observer listener) {
		listeners.remove(listener);
		listener.subject = this;
	}
	
	abstract void notification();

}
