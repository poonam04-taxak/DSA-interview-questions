public class SearchInRoatedArraySearch {
    public static int roated(int[]arr,int target){
        int start=0;
        int end=arr.length-1;
     while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
            return mid;
        }
        //check if left part is sorted
        if(arr[start]<=arr[mid]){
            if(arr[start]<=target && target<=arr[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        //left part is sorted
        else{
            if(arr[mid]<target && target<=arr[end]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
     }
     return -1;
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6};
        int target=5;
        int indx=roated(arr,target);
        System.out.println(indx);

    }
}
