//Brute Force Approach

/*public class RemoveOutermostParentheses {
public static String removepara(String s){
    StringBuilder result=new StringBuilder();
        int count=0;
        int start=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                result.append(s.substring(start+1,i));
                start=i+1;
            }
        }
        return result.toString();
}
        
    public static void main(String[] args) {
        String s="(()())(())";
   System.out.println(removepara(s));
    }
}
*/

//optimized approach
public class RemoveOutermostParentheses{

    public static String remove(String s){
        StringBuilder result=new StringBuilder();
        int depth=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(depth>0){
                    
                    result.append(ch);
                }
                depth++;
            }
                else{
                    depth--;
                    if(depth>0){
                        result.append(ch);
                    }
                }
            }
            return result.toString();
        
        
    }
    public static void main(String[] args) {
        String s="(()())(())";
        System.out.println(remove(s));
    }
}