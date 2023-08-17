package sud.aufgaben.occupationalTherapy.observer;

public class WeatherObserver implements Observer<WeatherData> {
    private WeatherData wd;

    public void update(WeatherData info) {
        this.wd.setMesswerte(
            info.getTemperatur(),
            info.getFeuchtigkeit(),
            info.getLuftdruck()
        );
    }
}
