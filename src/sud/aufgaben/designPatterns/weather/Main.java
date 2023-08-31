package sud.aufgaben.designPatterns.weather;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
    static Random zM = new Random();

    public static void main(String[] args) {

        System.out.println("--------------WETTERSTATION TESTLAUF--------------");

        JLabel currentConditionsLabel = new JLabel("Default text value for JLabel component.");
        JLabel weatherForecastLabel = new JLabel();
        WeatherData weatherData = new WeatherData(26, 20, 1000);
        WeatherApp app = new WeatherApp(weatherData);
        CurrentConditions currentWeatherConditions = new CurrentConditions(currentConditionsLabel);
        WeatherForecast weatherForecast = new WeatherForecast(weatherForecastLabel);

        app.getPanel().add(currentConditionsLabel);
        app.getPanel().add(weatherForecastLabel);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

        weatherData.addObserver(currentWeatherConditions);
        weatherData.addObserver(weatherForecast);

        try {
            for (int i = 0; i < 180; i++) {
                int welcher = zM.nextInt(3);
                float wert = 0f;
                switch (welcher) {
                case 0:
                    weatherData.setTemperature(weatherData.getTemperature() + (zM.nextInt(8) - 4));
                    break;
                case 1:
                    wert = weatherData.getHumidity() + zM.nextInt(40) - 20;
                    if (wert >= 0)
                        weatherData.setHumidity(wert);
                    break;
                case 2:
                    wert = weatherData.getAirPressure() + zM.nextInt(30) - 15;
                    if (wert >= 650)
                        weatherData.setAirPressure(wert);
                    break;
                }
                Thread.sleep(1000);
            }

            System.out.println("Things got removed, tho!");
            Thread.sleep(500);
            weatherData.setData(28, 16, 78);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
