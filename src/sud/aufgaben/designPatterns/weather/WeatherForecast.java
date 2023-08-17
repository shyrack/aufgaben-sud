package sud.aufgaben.designPatterns.weather;

import javax.swing.JLabel;

public class WeatherForecast implements Observer<WeatherData> {
    private JLabel label;

    public WeatherForecast(JLabel label) {
        this.label = label;
    }

    public void update(WeatherData weatherData) {
        // System.out.println("WeatherData.java got called with some serious data!");
        // System.out.println("Air pressure: " + weatherData.getAirPressure());
        // System.out.println("Humidity: " + weatherData.getHumidity());
        // System.out.println("Temperature: " + weatherData.getTemperature());
    }

}
