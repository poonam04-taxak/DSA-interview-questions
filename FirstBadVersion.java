
public class FirstBadVersion {
    // Mock API (replace with actual API during implementation)
    public static boolean isBadVersion(int version) {
        int firstBad = 4; // example
        return version >= firstBad;
    }

    public static int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid; // potential first bad, search left
            } else {
                low = mid + 1; // search right
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n = 5;
        int bad = firstBadVersion(n);
        System.out.println("First bad version is: " + bad);
    }
}
