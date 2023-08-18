package sud.aufgaben.occupationalTherapy.observer;

public class AktuelleBedingungen implements Observer<WeatherData> {
    public void update(WeatherData info) {
        System.out.println("-----AKTUELLE BEDINGUNGEN-----");
        System.out.println("Temperatur: " + info.getTemperatur() + "C");
        System.out.println("Feuchtigkeit: " + info.getFeuchtigkeit() + "%");
        System.out.println("Luftdruck: " + info.getLuftdruck() + "hPa");
    }
}
