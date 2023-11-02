package util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class HelperFunctions {

    public static String buildCSV(String[] values) {
        return HelperFunctions.join(values, ";");
    }

    public static String join(String[] arr, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
            if (i != arr.length - 1) {
                builder.append(s);
            }
        }
        return builder.toString();
    }

    public static <T> boolean includes(T[] arr, T t) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T, U> List<U> map(T[] arr, Function<T, U> func) {
        List<U> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            T element = arr[i];
            U result = func.apply(element);
            list.add(result);
        }
        return list;
    }

}
