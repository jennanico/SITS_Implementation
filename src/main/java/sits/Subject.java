package sits;

import java.util.ArrayList;

public abstract class Subject {
	
	/*
	 * Subject class for SITS program.
	 * Defines an abstract framework for a subject which is to be observed (i.e., Observer pattern.)
	 */
	
	ArrayList<Observer> listeners;	// list of observers
	
	/*
	 * Register an observer.
	 * @param listener		observer to be added to internal listeners list
	 */
	public void register(Observer listener) {
		listeners.add(listener);
		listener.subject = this;
	}
	
	/*
	 * De-register an observer.
	 * @param listener		observer to be removed from internal listeners list
	 */
	public void deregister(Observer listener) {
		listeners.remove(listener);
		listener.subject = this;
	}
	
	
	abstract void notification();

}
