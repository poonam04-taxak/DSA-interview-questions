import java.util.*;
public class MissingNumber{
    public static int missingNumber(int [] nums){
        int n=nums.length;
        int expectedsum=n*(n+1)/2;
        int actualsum=0;
        for(int i:nums){
         actualsum+=i;
        }
        return expectedsum-actualsum;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements (from 0 to n with one missing):");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int missing = missingNumber(nums);
        System.out.println("Missing number is: " + missing);
    }
}