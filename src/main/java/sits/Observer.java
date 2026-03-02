package sits;

public abstract class Observer {
	
	/*
	 * Observer class for SITS program.
	 * Holds a subject and an update method.
	 */
	
	Subject subject;

	abstract void update();

}
