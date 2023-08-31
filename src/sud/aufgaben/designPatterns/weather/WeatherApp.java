package sud.aufgaben.designPatterns.weather;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        public ToggleRegisterListener() {
            super();
            this.registered = true;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Observer<WeatherData> observer : weatherData.getObservers()) {
                if (this.registered) {
                    weatherData.removeObserver(observer);
                } else {
                    weatherData.addObserver(observer);
                }
            }
            this.registered = !this.registered;
        }
    }
}
