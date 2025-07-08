public class SingleElementInSortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 2; // note: n - 2
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1; // pair correct, search right
            } else {
                high = mid - 1; // pair broken, search left
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        int single = singleNonDuplicate(nums);
        System.out.println("Single element is: " + single);
    }
}

