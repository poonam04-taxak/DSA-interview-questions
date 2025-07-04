import java.util.*;
public class ContainsDuplicates{
public static boolean duplicates(int[]arr){
Set<Integer> seen=new HashSet<>();
for(int num:arr){
    if(seen.contains(num)){
        return true;
    }
    seen.add(num);
}  
return false;  
}

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
            System.out.println("enter your array size:");
            int n=sc.nextInt();
            int[] arr=new int[n];

            System.out.println("enter your elements:");
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();

            }
            sc.close();
            boolean result=duplicates(arr);
            System.out.println(result);
    }
}