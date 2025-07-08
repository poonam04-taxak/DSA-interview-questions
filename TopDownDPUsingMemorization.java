import java.util.*;
public class TopDownDPUsingMemorization {
    static int fib(int n,int[]dp){
     if(n==0 ||n==1){
        return n;
     }
     if(dp[n]!=-1){
        //if already computed return -1 If fib(n) has been computed before (not -1), return it directly, avoiding redundant recursive calls.
        return dp[n];
     }
     //store and return
     dp[n]=fib(n-1,dp)+fib(n-2,dp);
     return dp[n];
       }
    
       public static void main(String[] args) {
        int n=6;
        int[]dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(fib(n,dp));
    }
}
