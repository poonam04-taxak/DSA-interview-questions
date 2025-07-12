import java.util.*;
public class PalindromePartition {
    public static List<List<String>> partition(String s){
        List<List<String>> result=new ArrayList<>();
       List<String>curr=new ArrayList<>();
       backtrack(s,0,curr,result);
       return result;
    }

    public static void backtrack(String s,int start,List<String>curr,List<List<String>> result){
        if(start==s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int end=start+1;end<=s.length();end++){
        String substr=s.substring(start,end);
        if(isPalindrome(substr)){
            curr.add(substr);
            backtrack(s,end,curr,result);
            curr.remove(curr.size()-1);
        }

        }
    }

    private static boolean isPalindrome(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="aab";
        List<List<String>> ans=partition(s);
        System.out.println(ans);
    }
}
