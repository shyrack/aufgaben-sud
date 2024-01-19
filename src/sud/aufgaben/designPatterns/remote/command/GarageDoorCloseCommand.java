package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Garage;

public class GarageDoorCloseCommand implements Command {
    private Garage garage;

    public GarageDoorCloseCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        this.garage.close();
    }

    @Override
    public String getName() {
        return "Close garage door";
    }

    @Override
    public void undo() {
        this.garage.open();
    }
}
