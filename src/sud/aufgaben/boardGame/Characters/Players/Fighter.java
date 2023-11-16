package boardGame.Characters.Players;

import boardGame.Weapons.WeaponBehavior;

public abstract class Fighter extends Player {
    private WeaponBehavior weapon;

    public Fighter(String name) {
        super(name, 2, 5, 4, 4);
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    public WeaponBehavior getWeapon() {
        return this.weapon;
    }
}
