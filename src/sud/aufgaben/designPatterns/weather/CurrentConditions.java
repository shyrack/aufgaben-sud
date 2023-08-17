package sud.aufgaben.designPatterns.weather;

import javax.swing.JLabel;

public class CurrentConditions implements Observer<WeatherData> {
    private JLabel label;

    public CurrentConditions(JLabel label) {
        this.label = label;
    }

    public void update(WeatherData weatherData) {
        // System.out.println("CurrentConditions.java got called with some serious
        // data!");
        // System.out.println("Air pressure: " + weatherData.getAirPressure());
        // System.out.println("Humidity: " + weatherData.getHumidity());
        // System.out.println("Temperature: " + weatherData.getTemperature());
        this.label.setText("<html>Air pressure: " + weatherData.getAirPressure() + "hPa<br />" + "Humidity: "
                + weatherData.getHumidity() + "%<br />" + "Temperature: " + weatherData.getTemperature() + "°C</html>");
        this.label.updateUI();
    }

}
