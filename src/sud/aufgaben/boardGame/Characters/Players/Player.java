package boardGame.Characters.Players;

import boardGame.Characters.Figure;

public abstract class Player extends Figure {
    public Player(String name, int intelligence, int strength, int constitution, int agility) {
        super(name, intelligence, strength, constitution, agility);
    }

    public void move() {}
}
