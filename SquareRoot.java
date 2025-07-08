public class SquareRoot {
    public static int sqrt(int x){
        int start=0;
        int end=x;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<=x/mid){  //equivalent to mid*mid <= x without overflow
         ans=mid;
         start=mid+1;
            }
            else{
             end=mid-1;
            }
            
        }
        return ans;
    }
   public static void main(String[] args) {
    int x=8;
    int sqr=sqrt(x);
    System.out.println(sqr);
   } 
}
