package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Garage;

public class GarageDoorOpenCommand implements Command {
    private Garage garage;

    public GarageDoorOpenCommand(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void execute() {
        this.garage.open();
    }

    @Override
    public String getName() {
        return "Open garage door";
    }

    @Override
    public void undo() {
        this.garage.close();
    }
}
