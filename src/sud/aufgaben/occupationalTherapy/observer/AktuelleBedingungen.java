package occupationalTherapy.observer;

import javax.swing.JLabel;

public class AktuelleBedingungen extends JLabel implements Observer<WeatherData> {
    public AktuelleBedingungen() {
        super("Es sind noch keine aktuellen Bedingungen vorhanden");
    }

    public void update(WeatherData info) {
        String text = "Aktuelle Bedingungen:<br/>"
                    + "Temparatur: \t" + info.getTemperatur() + "C<br/>"
                    + "Feuchtigkeit: \t" + info.getFeuchtigkeit() + "%<br/>"
                    + "Luftdruck: \t" + info.getLuftdruck() + "hPa<br/>";
        this.setText("<html>" + text + "<br/></html>");
        System.out.println(text.replace("<br/>", "\n"));
    }
}
