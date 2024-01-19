package sud.aufgaben.designPatterns.remote;

import java.util.Stack;

public class Remote {
    private Command command;
    private Stack<Command> executedCommands;

    public Remote() {
        this.executedCommands = new Stack<>();
    }

    public void invoke() {
        this.command.execute();
        this.executedCommands.add(this.command);
    }

    public void undo() {
        if (!this.executedCommands.empty()) {
            Command command = this.executedCommands.pop();
            command.undo();
        }
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
