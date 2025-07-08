public class FindInRoatedSortedArray {
    public static int findMin(int[]arr){
        int start=0;
        int end=arr.length-1;
        int ans=Integer.MAX_VALUE;
        while(start<=end){
            if(arr[start]<=arr[end]){
                ans=Math.min(ans,arr[start]);
                break;
            }
            int mid=start+(end-start)/2;
            ans=Math.min(ans,arr[mid]);

            if(arr[start]<=arr[mid]){
                //left part is sorted
          start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,0,1,2};
        int min=findMin(arr);
        System.out.println(min);
    }
}
