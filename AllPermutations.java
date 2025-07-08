public class AllPermutations {
    static void permute(int[]arr,int indx){
        if(indx==arr.length){
            for(int num:arr){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for(int j=indx;j<arr.length;j++){
            //swap arr[index ]with arr[j]
            int temp=arr[indx];
            arr[indx]=arr[j];
            arr[j]=temp;

            //recursion for next indx
            permute(arr,indx+1);

            //backtrack ->swap again
             temp =arr[indx];
            arr[indx]=arr[j];
            arr[j]=temp;
        }
    }
    public static void main(String[] args) {
        int[]arr={1,2,3};
        permute(arr,0);
    }
}
