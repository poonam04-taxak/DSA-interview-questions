import java.util.*;
public class LeftRoatedArray {
    public static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void rotate(int[]arr,int k){
        int n=arr.length;
        k=k%n;

        reverse(arr,0,k-1);
        reverse(arr,k,n-1);
        reverse(arr,0,n-1);


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("enter your ele:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        System.out.println("enter k val ");
        int k=sc.nextInt();
        sc.close();
        rotate(arr,k);

        System.out.println("array after left rotation:");
        for(int num:arr){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
