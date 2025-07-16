
public class StringToIntegerAtoi {

    public static int myAtoi(String s) {
        int i = 0, n = s.length();
        int sign = 1;
        int result = 0;

        // Step 1: Skip whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        // Step 3: Parse digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Step 4: Check overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42")); // 42
        System.out.println(myAtoi("   -42")); // -42
        System.out.println(myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words and 987")); // 0
        System.out.println(myAtoi("-91283472332")); // -2147483648
    }
}
/*📌 Purpose: Check for overflow before adding the digit
जब हम
result = result * 10 + digit;
करते हैं, तो अगर result बहुत बड़ा हुआ, यह integer overflow कर सकता है, जिससे गलत value आ जाएगी।

Java में:

Integer.MAX_VALUE = 2147483647

Integer.MIN_VALUE = -2147483648

हमें ensure करना है कि calculation के बाद result इन limits से बाहर न जाए।

🔹 Why overflow check is needed?
For example
result = 214748364
digit = 8
Now:
214748364 * 10 + 8 = 2147483648
✅ यह Integer.MAX_VALUE (2147483647) से बड़ा हो जाएगा ➔ overflow.

🔹 Formula:

if (result > (Integer.MAX_VALUE - digit) / 10) {
    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
}
कैसे काम करता है:
हमें check करना है:
result * 10 + digit > Integer.MAX_VALUE
➡️ यह check overflow को directly check करने से unsafe है।

इसलिए safe तरीके से:
result > (Integer.MAX_VALUE - digit) / 10
✅ अगर result इस value से बड़ा है, तो अगर हम:
result = result * 10 + digit;
करेंगे, यह overflow कर जाएगा।

Return:
✅ अगर sign = 1 (positive number बन रहा है),
तो return:


Integer.MAX_VALUE = 2147483647
✅ अगर sign = -1 (negative number बन रहा है),
तो return:
Integer.MIN_VALUE = -2147483648
🔹 Example Dry Run:
If:
result = 214748364
digit = 8
Calculate:
(Integer.MAX_VALUE - digit) / 10
= (2147483647 - 8) / 10
= 2147483639 / 10
= 214748363
Check:
result (214748364) > 214748363
✅ True ➔ overflow होगा।

Hence:
sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE
return कर देंगे। */