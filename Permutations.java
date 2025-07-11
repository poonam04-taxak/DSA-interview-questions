import java.util.*;
//by using swaping
public class Permutations {
    public static void generatePermutations(int[] nums, int index) {
        if (index == nums.length) {
            System.out.println(Arrays.toString(nums)); // Print the permutation
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Choice lena: swap current index with i
            swap(nums, index, i);

            // Explore
            generatePermutations(nums, index + 1);

            // Backtrack: swap wapas to clean state
            swap(nums, index, i);
        }
    }

    // Helper function to swap elements in the array
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // Change input here
        generatePermutations(nums, 0);
    }
}


/*import java.util.*;

public class PermutationBacktracking {
    
    public static void generatePermutations(int[] nums, boolean[] used, List<Integer> current) {
        if (current.size() == nums.length) {
            System.out.println(current); // Print the permutation
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                // choice lena
                current.add(nums[i]);
                used[i] = true;

                // explore
                generatePermutations(nums, used, current);

                // backtrack
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // You can change input here
        boolean[] used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        
        generatePermutations(nums, used, current);
    }
}
 */


 /*class Solution {
    public ArrayList<String> findPermutation(String s) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // For lexicographical order
        backtrack(chars, 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, ArrayList<String> result) {
        if (index == chars.length) {
            result.add(new String(chars)); // Add permutation
            return;
        }

        HashSet<Character> seen = new HashSet<>(); // avoid duplicate swaps at current level

        for (int i = index; i < chars.length; i++) {
            if (!seen.contains(chars[i])) { // skip duplicates
                seen.add(chars[i]);

                swap(chars, index, i); // choice lena
                backtrack(chars, index + 1, result);
                swap(chars, index, i); // backtrack
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
 */