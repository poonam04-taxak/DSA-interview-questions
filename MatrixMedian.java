public class MatrixMedian {
    public static int Median(int[][]matrix){
        int r=matrix.length;
        int c=matrix[0].length;

        int start=Integer.MAX_VALUE;
        int end=Integer.MIN_VALUE;

        for(int i=0;i<r;i++){
            start=Math.min(start,matrix[i][0]);// first element in the row

            end=Math.max(end,matrix[i][c-1]);// last element in the row
        }
        int desired=(r*c)/2;
        while(start<end){
            int mid=start+(end-start)/2;
            int count=0;

            for(int i=0;i<r;i++){
                count+=countSmallerThanEqual(matrix[i],mid);
            }
            if(count<=desired){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }

    //counts ele<=target in row using upper bound
    private static int countSmallerThanEqual(int []row,int target){
        int start=0;
        int end=row.length;
        while(start<end){
            int mid=start+(end-start)/2;
            if(row[mid]<=target){
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
    }
  public static void main(String[] args) {
    int[][] matrix={
        {1,3,5},
        {2,6,9},
        {3,6,9}
    };
    System.out.println("Median of matrix is:" +Median(matrix));
  }  
}
