package sud.aufgaben.game.behaviors;

public class KnifeBehavior implements IWeaponBehavior {
    @Override
    public void use() {
        System.out.println("Stabs with knife!");
    }
}
