
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false; // Early exit if frequency goes negative
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("a", "a"));             // true
        System.out.println(isAnagram("a", "b"));             // false
    }
}
/*क्या है [c - 'a']?
जब हम lowercase English letters (‘a’ to ‘z’) की frequency गिनते हैं, हम character को 0-25 के बीच के index में map करना चाहते हैं।

ASCII Table पर आधारित:
'a' का ASCII value = 97

'b' का ASCII value = 98

'c' का ASCII value = 99

...

'z' का ASCII value = 122

जब तुम लिखते हो:
freq[c - 'a']++;
इसका मतलब:

c (character) का ASCII value लिया जाएगा।

'a' (ASCII 97) को subtract किया जाएगा।

इससे:

'a' - 'a' = 0

'b' - 'a' = 1

'c' - 'a' = 2

...

'z' - 'a' = 25

 */