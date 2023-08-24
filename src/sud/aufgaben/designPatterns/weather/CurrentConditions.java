package sud.aufgaben.designPatterns.weather;

import javax.swing.JLabel;

public class CurrentConditions implements Observer<WeatherData> {
    private JLabel label;

    public CurrentConditions(JLabel label) {
        this.label = label;
    }

    public void update(WeatherData weatherData) {
        this.label.setText("<html>Air pressure: " + weatherData.getAirPressure() + "hPa<br />" + "Humidity: "
                + weatherData.getHumidity() + "%<br />" + "Temperature: " + weatherData.getTemperature() + "°C</html>");
    }

}
