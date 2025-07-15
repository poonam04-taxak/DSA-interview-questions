public class ReversalString {
    public static void main(String[] args) {
        String s="lalit";
        char[] arr=s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;

        }
        String newStr=new String(arr);
        System.out.println(newStr);

    }
}
