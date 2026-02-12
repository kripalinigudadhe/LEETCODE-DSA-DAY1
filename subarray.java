import java.util.*;

public class subarray {

    public static int longestBalanced(int[] nums) {

        int n = nums.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            // Pruning optimization
            if (n - i <= maxLength)
                break;

            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();

            for (int j = i; j < n; j++) {

                if (nums[j] % 2 == 0)
                    even.add(nums[j]);
                else
                    odd.add(nums[j]);

                if (even.size() == odd.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    // PSVM
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = longestBalanced(nums);

        System.out.println("Longest Balanced Subarray Length: " + result);

        sc.close();
    }
}
