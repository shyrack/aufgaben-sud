package sud.aufgaben.designPatterns.remote;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import sud.aufgaben.designPatterns.remote.command.GarageDoorCloseCommand;
import sud.aufgaben.designPatterns.remote.command.GarageDoorOpenCommand;
import sud.aufgaben.designPatterns.remote.command.TurnLightOffCommand;
import sud.aufgaben.designPatterns.remote.command.TurnLightOnCommand;
import sud.aufgaben.designPatterns.remote.receiver.Garage;
import sud.aufgaben.designPatterns.remote.receiver.Light;
import sud.aufgaben.designPatterns.remote.receiver.Receiver;
import sud.aufgaben.designPatterns.remote.userInterface.RemoteUserInterface;;

public class Test {
    public static void main(String[] args) {
        // Initialize receivers
        Light light = new Light("Light in living room");
        Garage garage = new Garage();

        // Initialize commands
        List<Command<? extends Receiver>> commands = new ArrayList<>();
        commands.add(new TurnLightOnCommand(light));
        commands.add(new TurnLightOffCommand(light));
        commands.add(new GarageDoorOpenCommand(garage));
        commands.add(new GarageDoorCloseCommand(garage));

        // Initialize user interface components
        JFrame frame = new JFrame();
        RemoteUserInterface remoteInterface = new RemoteUserInterface();
        remoteInterface.visualizePanel(commands);
        frame.add(remoteInterface.getPanel());
        frame.setVisible(true);
    }
}
