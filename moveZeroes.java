import java.util.*;
public class moveZeroes {
    public static void moveZeroToEnd(int[]arr){
        int nonZeroIndx=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[nonZeroIndx]=arr[i];
                nonZeroIndx++;
            }
        }
    //fill remaning space with 0
    while(nonZeroIndx<arr.length){
        arr[nonZeroIndx]=0;
        nonZeroIndx++;
    }
    }
   public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("enter your array size: ");
    int n=sc.nextInt();
    int[] arr=new int[n];

    System.out.println("enter your ele:");
    for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
    }
    sc.close();

    moveZeroToEnd(arr);

    System.out.println("array afer moving all zero at end: ");
    for(int num:arr){
        System.out.println(num + " ");
    }
    System.out.println();
   } 
}
