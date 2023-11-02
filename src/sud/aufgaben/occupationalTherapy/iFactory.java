package occupationalTherapy;

import java.util.Scanner;

public interface iFactory<T> {
    public T create(String type, Scanner scanner);    
}