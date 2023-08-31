package sud.aufgaben.designPatterns.weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WeatherApp extends JFrame {
    private JPanel panel;
    private WeatherData weatherData;

    public WeatherApp(WeatherData weatherData) {
        super();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        super.add(this.panel);
        this.weatherData = weatherData;
        JButton toggleRegisterButton = new JButton("Toggle observers!");
        toggleRegisterButton.addActionListener(new ToggleRegisterListener());
        this.panel.add(toggleRegisterButton);
    }

    public JPanel getPanel() {
        return this.panel;
    }

    private class ToggleRegisterListener implements ActionListener {
        private boolean registered;
        private List<Observer<WeatherData>> previousObservers;

        public ToggleRegisterListener() {
            super();
            this.registered = true;
            this.previousObservers = Collections.synchronizedList(new ArrayList<>());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (this.registered) {
                this.previousObservers.clear();
                this.previousObservers.addAll(WeatherApp.this.weatherData.getObservers());

                for (Observer<WeatherData> observer : WeatherApp.this.weatherData.getObservers()) {
                    WeatherApp.this.weatherData.removeObserver(observer);
                }
            } else {
                for (Observer<WeatherData> observer : this.previousObservers) {
                    WeatherApp.this.weatherData.addObserver(observer);
                }
            }
            this.registered = !this.registered;
        }
    }
}
