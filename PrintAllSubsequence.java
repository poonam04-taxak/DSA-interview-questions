public class PrintAllSubsequence {

    static void printsub(String s,int index,String curr){
        if(index==s.length()){
            System.out.println(curr);
            return ;

        }
        //include curr char
        printsub(s,index+1,curr+s.charAt(index));

        //exclude curr
        printsub(s,index+1,curr);

    }
 public static void main(String[] args) {
    String s="abc";
    System.out.println("all subsequence are:");
    printsub(s,0," ");
 }   
}
