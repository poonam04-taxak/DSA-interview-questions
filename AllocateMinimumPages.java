
public class AllocateMinimumPages {

    public static int findPages(int[] pages, int m) {
        int n = pages.length;
        if (m > n) {
            return -1; // More students than books
        }

        int low = Integer.MIN_VALUE, high = 0;
        for (int p : pages) {
            low = Math.max(low, p);
            high += p;
        }

        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(pages, m, mid)) {
                result = mid;
                high = mid - 1;//solution exist to end=mid-1 hoga
            } else {
                low = mid + 1;//solution not exist
            }
        }

        return result;
    }

    private static boolean isPossible(int[] pages, int m, int maxPages) {
        int studentCount = 1;//assume starting m ak stu h
        int currentPages = 0;

        for (int p : pages) {
            if (currentPages + p <= maxPages) {
                currentPages += p;
            } else {
                studentCount++;
                currentPages = p;
                if (studentCount > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pages = {10, 20, 30, 40};
        int m = 2;
        System.out.println("Minimum of the maximum pages: " + findPages(pages, m));
        // Expected: 60
    }
}
