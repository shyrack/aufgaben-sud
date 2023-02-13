package sud.aufgaben.loops;

public class LS01_TenGreenBottles {
    private static final String[] NUMS = {"No", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};

    public static void main(String[] args) {
        int bottles = NUMS.length - 1;
        do {
            for (int i = 0; i < 2; i++)
                System.out.println(NUMS[bottles] + " green bottle" + (bottles != 1 ? "s" : "") + " hanging on the wall" + (i == 0 ? "," : "."));
            bottles--;
            System.out.println("And if one green bottle should accidentally fall,");
            System.out.println("There'll be " + NUMS[bottles].toLowerCase() + " green bottle" + (bottles != 1 ? "s" : "") + " hanging on the wall.\n");
        } while (bottles > 0);
    }
}
