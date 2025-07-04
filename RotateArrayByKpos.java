import java.util.*;
public class RotateArrayByKpos {
    //helper method to reverseele from start to end
    public static void reverse(int[]arr,int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public static void rotateArray(int[] arr,int k){
        int n=arr.length;
        k=k%n;
         
        //step1=reverse entire array
        reverse(arr,0,n-1);

        //step 2=reverse first k ele
        reverse(arr,0,k-1);

        //step3=reverse remaning n-k ele
        reverse(arr,k,n-1);
    }
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
 System.out.println("enter your array size:");
 int n=sc.nextInt();
 int[] arr=new int[n];
 
 System.out.println("enter your ele:");
 for(int i=0;i<n;i++){
    arr[i]=sc.nextInt();
 }
 System.out.println("enter your K pos value:");
 int k=sc.nextInt();
 sc.close();

 rotateArray(arr,k);
 System.out.println("array after rotation:");
 for(int num:arr){
    System.out.println(num + " ");
 }
 System.out.println();
}
}
