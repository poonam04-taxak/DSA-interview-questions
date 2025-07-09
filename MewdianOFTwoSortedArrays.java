public class MewdianOFTwoSortedArrays {

    public static double findMed(int[]num1,int[]num2){
        if(num1.length>num2.length){
            return findMed(num2,num1);
        
        }
        int n1=num1.length;
        int n2=num2.length;
        int start=0;
        int end=n1;

        while(start<=end){
            int mid1=(start+end)/2;
            int mid2=(n1+n2+1)/2-mid1;

            int l1=(mid1==0)?Integer.MIN_VALUE:num1[mid1-1];
            int l2=(mid2==0)?Integer.MIN_VALUE:num2[mid2-1];
            int r1=(mid1==n1)?Integer.MAX_VALUE:num1[mid1];
            int r2=(mid2==n2)?Integer.MAX_VALUE:num2[mid2];
      
           if(l1<=r2 && l2<=r1){
            if((n1+n2)%2==0){
                return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            
            }
            else{
                return Math.max(l1,l2);
            }
           }
           else if(l1>r2){
            end=mid1-1;
           }
           else{
            start=mid1+1;
           }
        }
        return 0.0;

    }
    public static void main(String[] args) {
        int[] num1={1,3};
        int[]num2={2};
        System.out.println("Median is:" + findMed(num1,num2));

        int[]num3={1,2};
        int[] num4={3,4};
        System.out.println("median is: "+findMed(num3,num4));
    }
}
/*📌 Context
While finding the median of two sorted arrays, we partition each array:

cut1: partition position in nums1.

cut2: partition position in nums2.

We check:

Max of left parts (l1, l2)

Min of right parts (r1, r2)

to decide whether:

We have found the correct partition.

We need to move the binary search left or right.

📌 Meaning of Each:
1️⃣ l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
If cut1 == 0, it means there is no element on the left side of nums1 partition.

So, we set l1 = Integer.MIN_VALUE (as nothing is there, we treat it as the smallest possible).

Else:

Take the last element on the left side of the partition in nums1 → nums1[cut1 - 1].

2️⃣ l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
Same logic for nums2.

If cut2 == 0, no elements on the left of nums2 → Integer.MIN_VALUE.

Else:

Take nums2[cut2 - 1].

3️⃣ r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
If cut1 == n1, it means there are no elements on the right side of nums1.

We set r1 = Integer.MAX_VALUE (as nothing is there, we treat it as the largest possible).

Else:

Take the first element on the right side of the partition in nums1 → nums1[cut1].

4️⃣ r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
Same logic for nums2.

If cut2 == n2, no elements on the right of nums2 → Integer.MAX_VALUE.

Else:

Take nums2[cut2].

✅ Why do we use Integer.MIN_VALUE and Integer.MAX_VALUE?
To handle edge cases safely during partition checks:

Example:
If one array has all elements in the left partition, there will be no elements in the right partition.

Using MAX_VALUE ensures comparison with actual numbers from the other array succeeds without IndexOutOfBounds.

✅ Purpose in the Median Algorithm:
We check:


if (l1 <= r2 && l2 <= r1)
to confirm:

All elements in the left partitions are ≤ all elements in the right partitions.

This ensures correct median position in the combined sorted array.

🪄 In simple words:
These lines extract boundary values at the partitions while safely handling edges to:

✅ Decide if the partition is correct to compute the median,
✅ Or adjust the binary search window accordingly.

 */
/*| Iteration | cut1 | cut2 | l1  | l2 | r1  | r2  | Action     |
| --------- | ---- | ---- | --- | -- | --- | --- | ---------- |
| 1         | 0    | 2    | MIN | 3  | 2   | MAX | move right |
| 2         | 1    | 1    | 2   | 1  | MAX | 3   | found      |
 */