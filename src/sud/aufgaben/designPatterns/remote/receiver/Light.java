package sud.aufgaben.designPatterns.remote.receiver;

public class Light extends Receiver {
	private String description;
	private int state;

	public Light(String description) {
		this.description = description;
	}

	public void on() {
		System.out.println(this.description + " on");
	}

	public void off() {
		System.out.println(this.description + " off");
	}

	public void changeState(int state) {
		this.state = state;
		System.out.println(this.description + " state changed to " + this.state + "%");
	}

	@Override
	public String toString() {
		return this.description;
	}
}
