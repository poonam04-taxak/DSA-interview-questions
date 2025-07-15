public class ReverseWords {
    public static void main(String[] args) {
        String s = " I love Coding";

        String[] word=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=word.length-1;i>=0;i--){
            sb.append(word[i]);
            if(i!=0){
                sb.append("");
            }
        }
        System.out.println(sb.toString());
    }
}
/*class Solution {
    public String reverseWords(String s) {
        // Step 1: Remove leading/trailing spaces and split
        String[] words = s.trim().split("\\s+");
        
        // Step 2: Use StringBuilder to append words in reverse order
        StringBuilder sb = new StringBuilder();
        
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) { // add space except after the last word
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
}
 */
/* Dry Run:
Input:

s = "  I   love   coding  "
s.trim()

"I   love   coding"
s.split("\\s+")


["I", "love", "coding"]
StringBuilder sb appends in reverse:

Append "coding"

Append " "

Append "love"

Append " "

Append "I"

Final:
"coding love I"
✅ Time and Space Complexity:
✅ Time Complexity: O(n)

trim() → O(n)

split() → O(n)

reverse loop and append → O(n)

✅ Space Complexity: O(n)

Array of words → O(n)

StringBuilder → O(n)

✅ Use in Interviews:
“I used trim() to remove extra spaces and split("\\s+") to split on multiple spaces, then reversed the array of words using StringBuilder for O(n) time and O(n) space.”

 */