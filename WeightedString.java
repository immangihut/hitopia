import java.util.ArrayList;
import java.util.List;

public class WeightedString {

    public static void main(String[] args) {
        String alphabets = "abbcccd";
        int[] queries = {1, 3, 9, 8};
        String[] result = calculate(alphabets, queries);

        for (String res : result) {
            System.out.println(res);
        }
    }

    public static String[] calculate(String alphabets, int[] queries) {
        List<Integer> weights = new ArrayList<>();
        char currentChar = ' ';
        int currentWeight = 0;
        int count = 0;

        for (char c : alphabets.toCharArray()) {
            int charWeight = c - 'a' + 1;

            if (c == currentChar) {
                count++;
                currentWeight += charWeight;
            } else {
                currentChar = c;
                count = 1;
                currentWeight = charWeight;
            }

            for (int i = 1; i <= count; i++) {
                weights.add(charWeight * i);
            }
        }

        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (weights.contains(queries[i])) {
                result[i] = "Yes";
            } else {
                result[i] = "No";
            }
        }

        return result;
    }
}
