package sud.aufgaben.game.behaviors;

public class SwordBehavior implements IWeaponBehavior {
    @Override
    public void use() {
        System.out.println("Swings sword at an opponent!");
    }
}
