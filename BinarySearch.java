import java.util.*;
public class BinarySearch {
    public static int find(int[]arr,int targ){
        int start=0;
        int end=arr.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(arr[mid]==targ){
                return mid;
            }
            else if(arr[mid]<targ){
               start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter your array size: ");
    int n=sc.nextInt();
    int[] arr=new int[n];

    System.out.println("enter your elements: ");
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    System.out.println("enter your targetd value");
    int targ=sc.nextInt();
    sc.close();

    int index=find(arr,targ);
    if(index!=-1){
        System.out.println("your targeted ele found at: "+index);
    }
    else{
        System.out.println("sorry! your ele is not exist in this array");
    }
   } 
}
