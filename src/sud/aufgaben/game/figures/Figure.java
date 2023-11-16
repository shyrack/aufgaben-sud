package sud.aufgaben.game.figures;

import sud.aufgaben.game.behaviors.IWeaponBehavior;

public abstract class Figure {
    private IWeaponBehavior weaponBehavior;

    public Figure(IWeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public IWeaponBehavior getWeaponBehavior() {
        return this.weaponBehavior;
    }

    public void setWeaponBehavior(IWeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
