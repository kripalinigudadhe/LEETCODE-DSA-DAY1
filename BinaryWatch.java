import java.util.*;

public class BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        // Hours: 0 - 11
        for (int hour = 0; hour < 12; hour++) {

            // Minutes: 0 - 59
            for (int minute = 0; minute < 60; minute++) {

                // Count total set bits
                int totalBits = Integer.bitCount(hour) + Integer.bitCount(minute);

                if (totalBits == turnedOn) {
                    // Format minute to always have 2 digits
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }

        return result;
    }

    // PSVM (Main Method)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of LEDs turned on: ");
        int turnedOn = sc.nextInt();

        BinaryWatch sol = new BinaryWatch();  // ✅ Fixed here
        List<String> result = sol.readBinaryWatch(turnedOn);

        System.out.println("Possible Times:");
        System.out.println(result);

        sc.close();
    }
}
