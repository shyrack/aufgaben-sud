package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Light;

public class TurnLightOffCommand implements Command {
    private Light light;

    public TurnLightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.off();
    }

    @Override
    public String getName() {
        return "Turn light off";
    }

    @Override
    public void undo() {
        this.light.on();
    }
}
