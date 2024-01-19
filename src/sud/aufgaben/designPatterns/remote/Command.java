package sud.aufgaben.designPatterns.remote;

public interface Command {
    void execute();

    String getName();

    void undo();
}
