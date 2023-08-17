package sud.aufgaben.designPatterns.weather;

public class CurrentConditions implements Observer<WeatherData> {

    public void update(WeatherData weatherData) {
        System.out.println("CurrentConditions.java got called with some serious data!");
        System.out.println("Air pressure: " + weatherData.getAirPressure());
        System.out.println("Humidity: " + weatherData.getHumidity());
        System.out.println("Temperature: " + weatherData.getTemperature());
    }

}
