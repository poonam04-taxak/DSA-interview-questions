import java.util.*;
public class TwoSum{
    public static int[] sum(int[]arr,int target){
        Map<Integer,Integer> map=new HashMap<>();
 for(int i=0;i<arr.length;i++){
    int complement=target-arr[i];
    if(map.containsKey(complement)){
return new int[]{map.get(complement),i};

    }
    map.put(arr[i],i);
 }
 return new int[]{};
    }
    public static void main(String args[]){
Scanner sc=new Scanner(System.in);
System.out.println("enter array size:");
int n=sc.nextInt();
int [] arr=new int[n];

System.out.println("enter your ele:");
for(int i=0;i<n;i++){
    arr[i]=sc.nextInt();

}
System.out.println("enter your target");
int target=sc.nextInt();
sc.close();
int [] result=sum(arr,target);
System.out.println("indices of ele that add up to target");
for(int indx:result){
System.out.println(indx);
}
System.out.println();
    }
}