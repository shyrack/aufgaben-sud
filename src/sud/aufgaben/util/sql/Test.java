package util.sql;

public class Test {

    private String name;
    private int age;
    private TestExtended extended;

    public Test(String name, int age, String color, int size, int weight) {
        this.name = name;
        this.age = age;
        this.extended = new TestExtended(this, color, size, weight);
    }

}
