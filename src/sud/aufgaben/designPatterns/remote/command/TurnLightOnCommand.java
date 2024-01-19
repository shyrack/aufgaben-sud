package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Light;

public class TurnLightOnCommand implements Command {
    private Light light;

    public TurnLightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }

    @Override
    public String getName() {
        return "Turn light on";
    }

    @Override
    public void undo() {
        this.light.off();
    }
}
