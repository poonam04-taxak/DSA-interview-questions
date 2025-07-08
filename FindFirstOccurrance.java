public class FindFirstOccurrance {
    public static int occurrance(int[]arr,int target){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
           ans=mid;
        end=mid-1;  
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[]arr={1,2,2,3,3,4};
        int target=2;
       int indx= occurrance(arr,target);
    System.out.println(indx);
    }

}
/*Q: Jab mid par ans mil gaya, to left me kyu search karna hai?
Reason:

Hume first occurrence (sabse left wali position) chahiye, sirf koi bhi position nahi.

Array me duplicate elements ho sakte hain.

Example:
arr = [1, 2, 2, 2, 3, 4], target = 2

Suppose pehli baar mid = 2 par mil gaya (index 2, value 2).

Lekin shayad 2 uske left side me bhi ho (index 1, value 2).

 */