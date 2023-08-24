package sud.aufgaben.occupationalTherapy.observer;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class WetterApp extends JFrame {

    public WetterApp(
        AktuelleBedingungen aktuell,
        WetterVorhersage vorhersage
    ) {
        super("Wetter App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        panel.add(aktuell, c);

        c.gridy++;
        panel.add(vorhersage, c);

        this.getContentPane().add(panel);
        this.pack();
        this.setSize(400, 200);

        this.setVisible(true);
    }    
}

