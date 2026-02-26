package sits;

import java.util.ArrayList;

public abstract class Subject {
	
	ArrayList<Observer> listeners;
	
	abstract void register(Observer listener);
	abstract void deregister(Observer listener);
	abstract void notification();

}
