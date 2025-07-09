
import java.util.Arrays;

public class AggressiveCows {

    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1; // Minimum possible distance
        int high = stalls[n - 1] - stalls[0]; // Maximum possible distance
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlaceCows(stalls, k, mid)) {
                ans = mid;          // possible, try for a larger distance
                low = mid + 1;
            } else {
                high = mid - 1;     // not possible, try for a smaller distance
            }
        }
        return ans;
    }

    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int count = 1;  // place the first cow at stalls[0]
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                count++;
                lastPosition = stalls[i];
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println("Maximum minimum distance: " + aggressiveCows(stalls, k));
        // Expected output: 3
    }
}
