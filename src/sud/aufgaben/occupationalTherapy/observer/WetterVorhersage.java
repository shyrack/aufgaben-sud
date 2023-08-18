package sud.aufgaben.occupationalTherapy.observer;

public class WetterVorhersage implements Observer<WeatherData>{
    public void update(WeatherData info) {
        System.out.println("-----VORHERSAGE-----");
        System.out.println("Temperatur: \t" + info.getTemperatur() + "C");
        System.out.println("Feuchtigkeit: \t" + info.getFeuchtigkeit() + "%");
        System.out.println("Luftdruck: " + info.getLuftdruck() + "hPa");
    }
}
