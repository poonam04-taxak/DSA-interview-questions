public class FindPeakEle {
    public static int peak(int[]arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid=start+(end-start)/2;
   if(arr[mid]>arr[mid+1]){
    end=mid;
   }
   else{
    start=mid+1;;
   }
        }
        return start;
    }
    public static void main(String[] args) {
        int[] arr={0,1,2,4,8,9};
        int peakIndex=peak(arr);
        System.out.println("peak ele index is: " +peakIndex +"and peak value is :"+ arr[peakIndex]);
    }
}
