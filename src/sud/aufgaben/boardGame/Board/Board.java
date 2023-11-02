package boardGame.Board;

public class Board {
    private Field[][] fields;

    public Board(int sizeX, int sizeY) {
        fields = new Field[sizeX][sizeY];
        for (int j = 0; j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                if (Math.random() < 0.5) {
                    fields[i][j] = createRandomRoom();
                } else {
                    fields[i][j] = createRandomHallway();
                }
            }
        }
    }

    public Field[][] getFields() {
        return this.fields;
    }

    private Hallway createRandomHallway(){
        int doorDirNum = (int)(Math.random() * 4);
            Direction doorDir1 = Direction.values()[doorDirNum];
            while (Direction.values()[doorDirNum] == doorDir1) {
                doorDirNum = (int)(Math.random() * 4);
            }
            Direction doorDir2 = Direction.values()[doorDirNum];
            return new Hallway(doorDir1, doorDir2);
    }

    private Room createRandomRoom() {
        double doorCount = Math.random();
        if (doorCount < 0.25) {
            return new Room();
        }
        int doorDirNum;

        doorDirNum = (int)(Math.random() * 4);
        Direction door1 = Direction.values()[doorDirNum];

        if (doorCount < 0.75) {
            while (Direction.values()[doorDirNum] == door1) {
                doorDirNum = (int)(Math.random() * 4);
            }
            Direction door2 = Direction.values()[doorDirNum];
            if (doorCount < 0.5) {
                while (
                    Direction.values()[doorDirNum] == door1 ||
                    Direction.values()[doorDirNum] == door2
                ) {
                    doorDirNum = (int)(Math.random() * 4);
                }
                Direction door3 = Direction.values()[doorDirNum];
                return new Room(door1, door2, door3);
            }
            return new Room(door1, door2);
        }
        return new Room(door1);
    }

    public static void main(String[] args) {
        Board board = new Board(5, 5);

        for (Field[] fieldRow : board.getFields()) {
            for (Field field : fieldRow) {
                System.out.println(field.toString());
            }
        }
    }
}
