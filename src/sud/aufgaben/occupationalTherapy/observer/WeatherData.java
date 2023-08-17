package sud.aufgaben.occupationalTherapy.observer;

public class WeatherData extends Subject<WeatherData> {

	private float temperatur;
	private float feuchtigkeit;
	private float luftdruck;
	public WeatherData(int t, int f, int l) {
		this.setMesswerte(t, f, l);
	}

	public void setMesswerte(float temp, float feucht, float luft){
		this.temperatur = temp;
		this.feuchtigkeit = feucht;
		this.luftdruck = luft;
		this.notifyObservers();
	}

	public void setTemperatur(float temparatur) {
		this.temperatur = temparatur;
		this.notifyObservers();
	}

	public void setFeuchtigkeit(float feuchtigkeit) {
		this.feuchtigkeit = feuchtigkeit;
		this.notifyObservers();
	}

	public void setLuftdruck(float luftdruck) {
		this.luftdruck = luftdruck;
		this.notifyObservers();
	}

	public float getFeuchtigkeit() {
		return feuchtigkeit;
	}

	public float getTemperatur() {
		return temperatur;
	}

	public float getLuftdruck() {
		return luftdruck;
	}

	public void notifyObservers() {
		for (Observer<WeatherData> ob : observers) {
			ob.update(this);
		}
	}
}
