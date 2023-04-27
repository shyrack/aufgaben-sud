package sud.aufgaben.occupationalTherapy;

public class Utils {
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

    public static String buildCSV(String[] arr) {
        return join(arr, ";");
    }
}
