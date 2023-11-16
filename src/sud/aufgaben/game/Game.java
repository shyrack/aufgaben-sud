package sud.aufgaben.game;

import sud.aufgaben.game.behaviors.MagicWandBehavior;
import sud.aufgaben.game.behaviors.SwordBehavior;
import sud.aufgaben.game.figures.Figure;
import sud.aufgaben.game.figures.Knight;
import sud.aufgaben.game.figures.Wizard;

public class Game {
    public Game() {
    }

    public void testFigures() {
        Wizard wizard = new Wizard(new MagicWandBehavior());
        Knight knight = new Knight(new SwordBehavior());
        Figure[] figures = new Figure[] { wizard, knight };

        for (Figure figure : figures) {
            figure.getWeaponBehavior().use();
        }
    }
}
