package sud.aufgaben.designPatterns.remote.receiver;

public class Garage extends Receiver {
	private boolean open;

	public boolean isOpen() {
		return this.open;
	}

	public void open() {
		System.out.println("Garage door opens!");
		this.open = true;
	}

	public void close() {
		System.out.println("Garage door closes!");
		this.open = false;
	}
}
