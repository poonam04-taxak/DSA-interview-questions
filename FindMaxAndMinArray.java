import java.util.*;
public class FindMaxAndMinArray {
    public static void findMaxMin(int[]arr){
        int max=arr[0];
        int min=arr[0];

        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("your max ele is: "+max);
        System.out.println("your min ele is: "+min);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your array size: ");
        int n=sc.nextInt();
        int[]arr=new int[n];

        System.out.println("enter your elements: ");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        findMaxMin(arr);

    }
}
