package sud.aufgaben.designPatterns.remote.receiver;

public class StereoSystem {
	private String cd;
	private boolean on;
	private boolean plays;
	private int volume;

	private enum Mode {
		CD, RADIO
	};

	private Mode currentMode = Mode.RADIO;

	public StereoSystem() {
		this.on = false;
		this.cd = "NO CD";
		this.volume = 4;
		this.plays = false;
	}

	public void playCd() {
		if (this.on) {
			this.plays = true;
			this.setCd();
			if (this.cd.equals("NO CD"))
				System.out.println("Lege zuerst eine CD ein.");
			else
				System.out.println("Starte das playback von " + this.cd);
		} else
			System.out.println("Erst muss die Anlage angestellt werden.");
	}

	public Mode getCurrentMode() {
		return currentMode;
	}

	public void playRadio() {
		if (this.on) {
			this.plays = true;
			this.setRadio();
			System.out.println("100,1 Das Hit-Radio! ...");
		} else
			System.out.println("Erst muss die Anlage angestellt werden.");
	}

	public void stopPlayback() {
		if (this.on) {
			System.out.println("Stoppe das Playback");
		}
		this.plays = false;
	}

	public void turnOn() {
		this.on = true;
		System.out.println("Die Stereoanlage ist jetzt AN");
	}

	public void turnOff() {
		this.on = false;
		this.plays = false;
		System.out.println("Die Stereoanlage ist jetzt aus");
	}

	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println("Aendere Lautstaerke auf " + volume);
	}

	public int getVolume() {
		return this.volume;
	}

	public void putCdIn(String cdName) {
		this.cd = cdName;
	}

	public void setCd() {
		System.out.println("Der aktuelle Modus ist CD.");
		this.currentMode = Mode.CD;
	}

	public void setRadio() {
		System.out.println("Der aktuelle Modus ist Radio");
		this.currentMode = Mode.RADIO;
	}

	public String getCurrentCd() {
		return this.cd;
	}
}
