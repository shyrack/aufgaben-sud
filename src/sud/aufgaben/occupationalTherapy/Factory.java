package occupationalTherapy;

import java.util.Scanner;

public interface Factory<T extends Object> {

    T create(String type, Scanner scanner);

}
