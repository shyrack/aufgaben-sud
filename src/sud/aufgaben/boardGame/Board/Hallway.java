package boardGame.Board;

/** A hallway is a field with exactly two doors */
public class Hallway extends Field {
    public Hallway(Direction a, Direction b) {
        this.doors = new Direction[]{a, b};
    }

    public String toString() {
        return "This is a Hallway " + super.toString();
    }
}
