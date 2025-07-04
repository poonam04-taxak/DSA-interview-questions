import java.util.*;
public class BestTimeToBuyAndSell{
    public static int maxprofit(int[]arr){
        int minprice=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int price:arr){
            if(price<minprice){
                minprice=price;       
                    }
            else if(price-minprice>maxprofit){
                maxprofit=price-minprice;
            }
            }
            return maxprofit;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter array size:");
        int n=sc.nextInt();
        int [] arr=new int[n];

        System.out.println("enter array ele");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            
        }
        sc.close();
        System.out.println("your profit is:");
        int profit=maxprofit(arr);
        System.out.println(profit);
    }
}
/*2️⃣ if(price < minPrice) { minPrice = price; }
If today's price is lower than the previously seen minimum, update minPrice.

It means: “If today’s price is cheaper, treat it as our new buying price.”

🪄 Purpose: Always buy at the lowest price so far.

3️⃣ else if(price - minPrice > maxProfit) { maxProfit = price - minPrice; }
If the profit we would get by selling at today's price (price - minPrice) is greater than the current maxProfit, update maxProfit.

🪄 Purpose: Check if selling today after buying at the lowest seen price gives a better profit.

✅ What happens if neither condition is true?
If:

price >= minPrice and

price - minPrice <= maxProfit

then nothing changes:

minPrice remains the same.

maxProfit remains the same.

🪄 Example for clarity:
For:

ini
Copy
Edit
prices = [7, 1, 5, 3, 6, 4]
Step by step:

Day	Price	minPrice update	profit = price - minPrice	maxProfit update
0	7	7	0	0
1	1	1	0	0
2	5	-	5 - 1 = 4	4
3	3	-	3 - 1 = 2	-
4	6	-	6 - 1 = 5	5
5	4	-	4 - 1 = 3	-

✅ Final maxProfit = 5 (Buy at 1, sell at 6).

✅ In simple words:
Track lowest buying price (minPrice) while traversing.

For each day, calculate the profit if sold today.

If this profit is the highest so far (maxProfit), update it.

Return maxProfit at the end.

If this is clear, reply:
✅ “Done, ready for Majority Element next.”

or

✅ “Give me a notebook summary to revise.”

to continue your systematic DSA + interview preparation efficient
 */