
public class CeilOfAnElement {
    public static int findCeil(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                ans = arr[mid]; // potential ceil
                high = mid - 1; // search left for a smaller ceil
            } else {
                low = mid + 1; // search right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 12};
        int target = 5;
        int ceil = findCeil(arr, target);
        System.out.println("Ceil of " + target + " is: " + ceil);
    }
}
