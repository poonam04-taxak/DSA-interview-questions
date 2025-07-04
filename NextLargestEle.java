import java.util.*;
public class NextLargestEle {
    public static int[] large(int [] arr){
        int n=arr.length;
        int[]result=new int[n];
        Stack<Integer> s=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                result[i]=-1;
            }
            else{
                result[i]=s.peek();
            }
            s.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("enter array ele:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        sc.close();
        int[] result=large(arr);
        System.out.println("next greater ele:");
        for(int num:result){
            System.out.println(num + " ");

        }
        System.out.println();
    }
}
