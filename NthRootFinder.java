public class NthRootFinder {
     // Function to compute mid^n safely
    public static long power(long mid,int n){
      long result=1;
      for(int i=0;i<n;i++){
        result *=mid;
        if(result>Long.MAX_VALUE){
            return Long.MAX_VALUE;// to avoid overflow issues
        }
      }
      return result;
    }
    public static int nthRoot(int x,int n){
        int start=1;
        int end=x;
        while(start<=end){
            int mid=start+(end-start)/2;
            long midPower=power(mid,n);
            if(midPower==x){
                return mid;
            }
            else if(midPower<x){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int x=27;
        int n=3;
        int root=nthRoot(x,n);
        if(root!=-1){
            System.out.println("the " +n + "th root of "+x +"is:" +root);
        }
        else{
            System.out.println(x + " does not have an exact " + n + "th root.");
        }
    }
}
/*1️⃣ Purpose:
To calculate:

𝑚𝑖𝑑^𝑛=𝑚𝑖𝑑×𝑚𝑖𝑑×…×𝑚𝑖𝑑(𝑛times)mid n
 =mid×mid×…×mid(n times)
without using Math.pow().

2️⃣ Why long result = 1;?
We will multiply mid with itself n times, starting from 1.

3️⃣ The for loop:
java
Copy
Edit
for (int i = 0; i < n; i++) {
    result *= mid;
    ...
}
Repeats n times:

Each iteration multiplies result by mid.

After the loop:


result
=
𝑚𝑖𝑑 𝑛
result=mid ^n
 
4️⃣ Why if (result > Long.MAX_VALUE)?
Actually, this line is conceptually incorrect and unnecessary, because:

Long.MAX_VALUE = 9223372036854775807 (largest value long can store).

If result exceeds this, it will overflow automatically and become negative or incorrect.

Checking if (result > Long.MAX_VALUE) is ineffective, because it will never be true.

✅ Correct and meaningful check:
In your Nth Root Binary Search, you only need to check:

if (result > x) {
    return result;
}
to prune the search when the power exceeds x, avoiding unnecessary computation and overflow risk for the problem’s constraints.

 */