package boardGame.Board;

enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST    
}

public abstract class Field {
    protected Direction[] doors;

    public String toString() {
        String str = "with " + doors.length + " doors: ";

        for (Direction door : doors) {
            str += door.name() + ", ";
        }

        return str.substring(0, str.length()-2);
    }
}
