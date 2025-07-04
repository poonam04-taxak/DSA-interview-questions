import java.util.*;
public class LinearSearchArray {
    public static int linearSearch(int[]arr,int target){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array : ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("enter your elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter your target: ");
        int target=sc.nextInt();
        sc.close();

        int index=linearSearch(arr,target);
        if(index!=-1){
            System.out.println("ele found at index: "+index);
        }
        else{
            System.out.println("sorry! your targeted ele is not found");
        }
    }
}
