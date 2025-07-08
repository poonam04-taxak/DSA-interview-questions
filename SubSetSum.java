import java.util.*;
public class SubSetSum {
    public static void sum(int[]arr,int len,int indx,int currsum,List<Integer>result){
        if(indx==len){
            result.add(currsum);
            return;
        }
        //include arr[indx]
        sum(arr,len,indx+1,currsum+arr[indx],result);

        //exclude arr[indx]
        sum(arr,len,indx+1,currsum,result);
    }
    public static void main(String[] args) {
        int[]arr={1,2,3};
        List<Integer> result=new ArrayList<>();
        sum(arr,arr.length,0,0,result);

        Collections.sort(result);
        System.out.println(result);
    }
}
/*Step-by-Step Dry Run on arr = [1, 2]
Initial Call:
scss
Copy
Edit
subsetSum(arr, 2, 0, 0, result)
Tree:
pgsql
Copy
Edit
               index=0 sum=0
              /             \
         include 1         exclude 1
        index=1 sum=1      index=1 sum=0
       /          \        /            \
  include 2   exclude 2  include 2    exclude 2
 index=2 sum=3  index=2 sum=1  index=2 sum=2  index=2 sum=0
✅ Jab index == n hota hai (yani index = 2 yahan):

sum = 3 add hota hai list me

sum = 1 add hota hai list me

sum = 2 add hota hai list me

sum = 0 add hota hai list me

Final Result:
[3, 1, 2, 0]
Sort karne par:
[0, 1, 2, 3]

Simple yaad rakhne ka tarika:
✅ Har recursion pe:

Include karen

Exclude karen

Base case par sum add kar dena hai

✅ Yahi pattern Subsets, Subset Sum, Combination Sum, etc. recursion problems me use hota hai.

 */