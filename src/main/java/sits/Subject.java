package sits;

import java.util.ArrayList;

public abstract class Subject {
	
	ArrayList<Observer> listeners;
	
	public void register(Observer listener) {
		listeners.add(listener);
	}
	
	public void deregister(Observer listener) {
		listeners.remove(listener);
	}
	
	abstract void notification();

}
