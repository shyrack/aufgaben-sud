package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Garage;

public class GarageDoorOpenCommand extends Command<Garage> {
    public GarageDoorOpenCommand(Garage garage) {
        super(garage);
    }

    @Override
    public void execute() {
        super.receiver.open();
    }

    @Override
    public String getName() {
        return "Open garage door";
    }

    @Override
    public void undo() {
        super.receiver.close();
    }
}
