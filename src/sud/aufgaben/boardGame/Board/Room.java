package boardGame.Board;

/** A room is a field which can have up to 4, but at least 1 entrance */
public class Room extends Field {
    public Room(Direction a) {
        this.doors = new Direction[]{a};
    }

    public Room(Direction a, Direction b) {
        this.doors = new Direction[]{a, b};
    }

    public Room(Direction a, Direction b, Direction c) {
        this.doors = new Direction[]{a, b, c};
    }

    /**
     * No parameters = Door in all directions
     */
    public Room() {
        this.doors = new Direction[]{
            Direction.NORTH,
            Direction.EAST,
            Direction.SOUTH,
            Direction.WEST
        };
    }

    public String toString() {
        return "This is a Room " + super.toString();
    }
}