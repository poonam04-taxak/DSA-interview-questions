import java.util.*;
public class SubArraySum {
    public static int maxSum(int arr[]){
        int maxSum=arr[0];
        int currSum=0;

        //add ele to currsum
        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];

            if(currSum>maxSum){
            maxSum=currSum;
            }
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your size:");
        int num=sc.nextInt();
        int arr[]=new int[num];

        System.out.println("enter your ele:");
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        int result=maxSum(arr);
System.out.println("sub array sum is:"+result);
    }
}
