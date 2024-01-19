package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Garage;

public class GarageDoorCloseCommand extends Command<Garage> {
    public GarageDoorCloseCommand(Garage garage) {
        super(garage);
    }

    @Override
    public void execute() {
        super.receiver.close();
    }

    @Override
    public String getName() {
        return "Close garage door";
    }

    @Override
    public void undo() {
        super.receiver.open();
    }
}
