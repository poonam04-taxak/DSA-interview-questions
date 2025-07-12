
import java.util.*;

public class KthPermutation {
    public static String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i); // [1,2,3,...,n]
        }

        int fact = 1;
        for (int i = 1; i < n; i++) fact *= i; // (n-1)!
        k = k - 1; // convert to 0-based

        StringBuilder sb = new StringBuilder();

        while (!nums.isEmpty()) {
            int index = k / fact; // find block
            sb.append(nums.get(index)); // take that digit
            nums.remove(index); // remove it

            if (nums.isEmpty()) break;

            k = k % fact; // update k
            fact = fact / nums.size(); // update block size
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 3;
        System.out.println(getPermutation(n, k)); // Output: 213
    }
}
