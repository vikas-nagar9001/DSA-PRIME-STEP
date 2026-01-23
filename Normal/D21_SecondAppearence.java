import java.util.HashMap;


public class D21_SecondAppearence {

    public static void count(String str, int length, HashMap<String, Integer> map) {

        if (length < 0) {
            return;
        }

        count(str, length - 1, map);

        String element = String.valueOf(str.charAt(length));

        map.put(element, map.getOrDefault(element, 0) + 1);

    }

    public static void main(String[] args) {

        String str = "abaddbacdcdadc";

        HashMap<String, Integer> map = new HashMap<>();

        count(str, str.length() - 1, map);
        System.out.println(map);

        int first = 0, second = 0;
        String firstChar = null, secondChar = null;

        for (String k : map.keySet()) {

            int value = map.get(k);

            if (value > first) {

                // WHEN WE CHANGE THE FIRST WE HAVE TO UPDATE THAT VALUE TO SECOND
                second = first;
                secondChar = firstChar;

                first = map.get(k);
                firstChar = k;
            } else if (value > second && value < first) {
                second = value;
                secondChar = k;
            }

        }

        System.out.println("First : " + firstChar);
        System.out.println("Second : " + secondChar);

    }
}
