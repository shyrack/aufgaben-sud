package sud.aufgaben.designPatterns.weather;

import javax.swing.JLabel;

public class WeatherForecast implements Observer<WeatherData> {
    private JLabel label;
    private float previousAirPressure;

    public WeatherForecast(JLabel label) {
        this.label = label;
        this.previousAirPressure = 1000;
    }

    public void update(WeatherData weatherData) {
        float airPressureChange = this.previousAirPressure - weatherData.getAirPressure();

        if (airPressureChange > 0) {
            this.label.setText("The weather is getting better!");
        } else if (airPressureChange < 0) {
            this.label.setText("The weather is getting worse!");
        } else {
            this.label.setText("The weather conditions are not changing!");
        }
        this.previousAirPressure = weatherData.getAirPressure();
    }

}
