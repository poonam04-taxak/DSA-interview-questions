import java.util.*;
public class SortedArray {

    public static boolean sort(int[] arr){
    for(int i=0;i<arr.length-1;i++){
        if(arr[i]>arr[i+1]){
            return false;
        }
    }
    return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
      System.out.println("enter array size:");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("your ele are:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();

        boolean result=sort(arr);
            if(result){
                System.out.println("array is sorted");
            }
            else{
                System.out.println("array is not sorted");
            }
        }

    }

