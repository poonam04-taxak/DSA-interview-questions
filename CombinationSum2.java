
import java.util.*;

public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr); // sort for duplicates handling
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, arr, target, curr, res);
        return res;
    }

    private static void backtrack(int start, int[] arr, int target,
                                   List<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr)); // add copy
            return;
        }

        for (int i = start; i < arr.length; i++) {
            // Skip duplicates in the same depth level
            if (i > start && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            curr.add(arr[i]); // pick
            backtrack(i + 1, arr, target - arr[i], curr, res); // move to i+1 (no reuse)
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ans = combinationSum2(arr, target);
        System.out.println(ans);
    }
}
/*import java.util.*;

class Solution {
    // Function to find all combinations of elements in arr that sum to target.
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        Arrays.sort(arr); // sort to handle duplicates easily
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        backtrack(0, arr, target, curr, result);
        return result;
    }

    public static void backtrack(int start, int[] arr, int target, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(curr)); // add a copy of current combination
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) continue; // skip duplicates

            if (arr[i] > target) break; // no need to proceed further

            curr.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], curr, result);
            curr.remove(curr.size() - 1); // backtrack
        }
    }

    // Optional testing main
    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        ArrayList<ArrayList<Integer>> ans = uniqueCombinations(arr, target);
        for (ArrayList<Integer> comb : ans) {
            System.out.println(comb);
        }
    }
}
 */