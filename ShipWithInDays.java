
public class ShipWithInDays {
    public static int shipWithinDays(int[] weights, int D) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w); // max weight
            high += w;              // sum of weights
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShip(weights, D, mid)) {
                high = mid; // try smaller capacity
            } else {
                low = mid + 1; // need bigger capacity
            }
        }
        return low; // or high
    }

    private static boolean canShip(int[] weights, int D, int capacity) {
        int days = 1, currentLoad = 0;
        for (int w : weights) {
            if (currentLoad + w > capacity) {
                days++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return days <= D;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        int minCapacity = shipWithinDays(weights, D);
        System.out.println("Minimum capacity required: " + minCapacity);
    }
}
