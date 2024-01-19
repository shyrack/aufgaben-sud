package sud.aufgaben.designPatterns.remote.command;

import sud.aufgaben.designPatterns.remote.Command;
import sud.aufgaben.designPatterns.remote.receiver.Light;

public class TurnLightOffCommand extends Command<Light> {
    public TurnLightOffCommand(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        super.receiver.off();
    }

    @Override
    public String getName() {
        return "Turn light off";
    }

    @Override
    public void undo() {
        super.receiver.on();
    }
}
