package occupationalTherapy.observer;

import javax.swing.JLabel;

public class WetterVorhersage extends JLabel implements Observer<WeatherData> {
    private float prevLuftdruck = 1000.0f;

    public WetterVorhersage() {
        super("Es sind noch keine Vorhersagen vorhanden.");
    }

    public void update(WeatherData info) {
        float currLuftdruck = info.getLuftdruck();
        String text = "Vorhersage:<br/>";
        if (currLuftdruck > prevLuftdruck) {
            text += "Das Wetter bessert sich! :)";
        } else if (currLuftdruck < prevLuftdruck) {
            text += "Das Wetter verschlechtert sich! :(";
        } else {
            text += "Das Wetter bleibt gleich! :|";
        }

        this.setText("<html>" + text + "</html>");
        System.out.println(text.replace("<br/>", "\n"));

        prevLuftdruck = currLuftdruck;
    }
}
