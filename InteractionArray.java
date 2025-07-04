import java.util.*;
public class InteractionArray {
    public static int[] Intersection(int[] arr1,int[] arr2){
        Set<Integer> set1=new HashSet<>();
        for(int num:arr1){
            set1.add(num);
        }
        Set<Integer> resultSet=new HashSet<>();
        for(int num:arr2){
            if(set1.contains(num)){
                resultSet.add(num);
            }
        }
        //convert hashset into set
        int[] result=new int[resultSet.size()];
        int indx=0;
        for(int num:resultSet){
            result[indx++]=num;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter size of 1st array:");
        int n=sc.nextInt();
        int[] arr1=new int[n];
        System.out.println("enter your ele of 1st array :");
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        System.out.println("enter size of 2nd array:");
        int m=sc.nextInt();
        int[] arr2=new int[m];
        System.out.println("enter your ele of 2nd array :");
        for(int i=0;i<n;i++){
            arr2[i]=sc.nextInt();
        }
        sc.close();
        int[] result=Intersection(arr1,arr2);
        System.out.println("after intersection:");
        for(int num:result){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
