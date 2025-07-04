import java.util.*;
public class ReversedArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your array size: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("your ele are: ");
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            
        }
        int start=0;
        int end=n-1;

        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    
    System.out.println("our reversed array is: ");
    for(int num:arr){
        System.out.print(num);
    }
    System.out.println();
    sc.close();
}
}
