public class PalindromeCheck {
    public static void main(String[] args) {
        String p="madam";
        if(isPalindrome(p)){
            System.out.println("yes, it is a palindrome ");
        }
        else{
            System.out.println("sorry! your string is not palindrome");
        }

    }
    static boolean isPalindrome(String p){
   int i=0;
   int j=p.length()-1;
   while(i<=j){
    if(p.charAt(i)!=p.charAt(j)){
        return false;
    }
    i++;
    j--;
   }
   return true;

    }

}
