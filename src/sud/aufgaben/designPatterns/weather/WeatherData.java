package sud.aufgaben.designPatterns.weather;

public class WeatherData extends Subject<WeatherData> {
    private float temperature;
    private float humidity;
    private float airPressure;

    public WeatherData(int t, int f, int l) {
        super();
        this.setData(t, f, l);
    }

    public void setData(float temperature, float humidity, float airPressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.airPressure = airPressure;
        this.notifyObservers();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
        this.notifyObservers();
    }

    public void setAirPressure(float airPressure) {
        this.airPressure = airPressure;
        this.notifyObservers();
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public float getAirPressure() {
        return airPressure;
    }

    @Override
    public void notifyObservers() {
        for (Observer<WeatherData> observer : super.observers) {
            observer.update(this);
        }
    }
}
