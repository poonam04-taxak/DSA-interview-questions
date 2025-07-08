
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int p : piles) {
            high = Math.max(high, p);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canEat(piles, h, mid)) {
                high = mid; // try smaller k
            } else {
                low = mid + 1; // need higher k
            }
        }
        return low; // or high
    }

    private static boolean canEat(int[] piles, int h, int k) {
        int hours = 0;
        for (int p : piles) {
            hours += (p + k - 1) / k; // equivalent to ceil(p / k)
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum eating speed: " + minSpeed);
    }
}
