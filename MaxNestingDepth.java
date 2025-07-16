
public class MaxNestingDepth {

    public static int maxDepth(String s) {
        int count = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                maxDepth = Math.max(maxDepth, count);
            } else if (ch == ')') {
                count--;
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s1)); // 3

        String s2 = "(1)+((2))+(((3)))";
        System.out.println(maxDepth(s2)); // 3

        String s3 = "1+(2*3)/(2-1)";
        System.out.println(maxDepth(s3)); // 1

        String s4 = "1";
        System.out.println(maxDepth(s4)); // 0
    }
}


/*| Char | Action  | count | maxDepth |
| ---- | ------- | ----- | -------- |
| '('  | count++ | 1     | 1        |
| ...  |         |       |          |
| '('  | count++ | 2     | 2        |
| ...  |         |       |          |
| '('  | count++ | 3     | 3        |
| ...  |         |       |          |
| ')'  | count-- | 2     | 3        |
| ')'  | count-- | 1     | 3        |
| ')'  | count-- | 0     | 3        |
| ...  |         |       |          |  ak bat bta is example m  4 to open bracket h or 4 hi close to tu count 3 hi bracket kyu kr rha h


ChatGPT said:
बहुत अच्छा सवाल, इसे आसान भाषा में पूरी clarity से समझो:

📌 Doubt:
"4 open brackets और 4 close brackets हैं, फिर count 3 क्यों आ रहा है maxDepth में?"

1️⃣ Count क्या बताता है?
count current depth बताता है (अभी कितने '(' खुले हैं और बंद नहीं हुए हैं)।

2️⃣ maxDepth क्या बताता है?
maxDepth उस पूरे string में maximum कितने depth तक nested हुए थे, उसे बताता है।

✅ Brackets का count और max depth अलग बातें हैं:
आपके input में total '(' = 4 और total ')' = 4 हैं, इसलिए brackets balanced हैं।

लेकिन nested कितनी गहराई तक गए, यह अलग बात है।

📌 Depth कैसे बनती है:
Example:
(1 + (2 * 3) + ((8)/4)) + 1
इसमें:

पहला '(' ➔ depth = 1

अंदर जाकर दूसरा '(' ➔ depth = 2

अंदर जाकर तीसरा '(' ➔ depth = 3 (maximum depth reached here)

फिर ')' मिलने पर depth = 2

फिर ')' ➔ depth = 1

फिर ')' ➔ depth = 0

✅ यहाँ maximum depth सिर्फ 3 बनी, भले ही total '(' = 4 क्यों ना हो।

🔥 Important:
maxDepth इस बात पर निर्भर करती है कि parentheses कितनी गहराई तक nested हैं, कितनी बार नहीं।

 */