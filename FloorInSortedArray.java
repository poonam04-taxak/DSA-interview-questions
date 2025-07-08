public class FloorInSortedArray {
    public static int findFloor(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                ans = arr[mid]; // potential floor
                low = mid + 1;   // search right for a larger floor
            } else {
                high = mid - 1;  // search left
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10, 12};
        int target = 5;
        int floor = findFloor(arr, target);
        System.out.println("Floor of " + target + " is: " + floor);
    }
}

