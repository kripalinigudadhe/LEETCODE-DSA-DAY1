import java.util.*;

public class CountSubstrings {

    public int countBinarySubstrings(String s) {

        int prevGroup = 0;
        int currGroup = 1;
        int ans = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                currGroup++;
            } else {
                ans += Math.min(prevGroup, currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }

        ans += Math.min(prevGroup, currGroup);

        return ans;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter binary string: ");
        String s = sc.nextLine();

        CountSubstrings obj = new CountSubstrings();
        int result = obj.countBinarySubstrings(s);

        System.out.println("Count = " + result);

        sc.close();
    }
}
