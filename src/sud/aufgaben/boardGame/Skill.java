package boardGame;

public class Skill {
    private int value;
    public static int MAX = 10;
    public static int MIN = 1;

    public Skill(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public void increaseValue(int dVal) {
        this.value = Math.min(Skill.MAX, this.value + dVal);
    }

    public void decreaseValue(int dVal) {
        this.value = Math.max(Skill.MIN, this.value - dVal);
    }
}
