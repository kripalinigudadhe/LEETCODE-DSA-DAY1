import java.util.*;

public class SpecialBinary {

    public String makeLargestSpecial(String s) {

        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            // When balanced substring found
            if (count == 0) {

                // Recursively solve inner substring
                String inner = makeLargestSpecial(s.substring(start + 1, i));

                list.add("1" + inner + "0");

                start = i + 1;
            }
        }

        // Sort in descending order
        Collections.sort(list, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }

        return result.toString();
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter special binary string: ");
        String s = sc.nextLine();

        SpecialBinary obj = new SpecialBinary();
        String result = obj.makeLargestSpecial(s);

        System.out.println("Lexicographically Largest Special String: " + result);

        sc.close();
    }
}