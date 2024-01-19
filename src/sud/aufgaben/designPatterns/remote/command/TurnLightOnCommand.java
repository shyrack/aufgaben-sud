package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Light;

public class TurnLightOnCommand extends Command<Light> {
    public TurnLightOnCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        super.receiver.on();
    }

    @Override
    public String getName() {
        return "Turn light on";
    }

    @Override
    public void undo() {
        super.receiver.off();
    }
}
