
public class PaintersPartitionProblem {

    public static int findMinTime(int[] boards, int k) {
        int n = boards.length;
        int low = 0, high = 0;
        for (int b : boards) {
            low = Math.max(low, b);
            high += b;
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(boards, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] boards, int k, int maxTime) {
        int painters = 1;
        int currentSum = 0;
        for (int b : boards) {
            if (currentSum + b <= maxTime) {
                currentSum += b;
            } else {
                painters++;
                currentSum = b;
                if (painters > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;
        System.out.println("Minimum time to paint all boards: " + findMinTime(boards, k));
        // Expected output: 60
    }
}
