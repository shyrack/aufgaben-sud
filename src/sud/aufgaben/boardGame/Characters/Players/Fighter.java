package boardGame.Characters.Players;

import boardGame.Weapon;

public abstract class Fighter extends Player {
    private Weapon weapon;

    public Fighter(String name) {
        super(name, 2, 5, 4, 4);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
