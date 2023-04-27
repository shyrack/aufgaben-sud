package sud.aufgaben.util;

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

}
