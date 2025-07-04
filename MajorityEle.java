import java.util.*;
public class MajorityEle{
    public static int majorityElement(int[] nums){
        int count=0;
        int candidate=0;
        for(int num:nums){
            if(count==0){
          candidate=num;
            }
             if(num==candidate){
                count++;
             }
             else{
                count--;
             }
        }
        return candidate;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of the array:");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();

        int result = majorityElement(nums);
        System.out.println("Majority element is: " + result);
    }
}