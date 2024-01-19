package sud.aufgaben.designPatterns.remote;

import sud.aufgaben.designPatterns.remote.receiver.Receiver;

public abstract class Command<T extends Receiver> {
    protected T receiver;

    public Command(T receiver) {
        this.receiver = receiver;
    }

    public abstract void execute();

    public abstract String getName();

    public abstract void undo();
}
