import java.util.*;
public class ContainerWithMostWater {
    public static int Water(int[]height){
        int left=0;
        int right=height.length-1;
         int maxArea=0;

         while(left<right){
            int width=right-left;
            int ht=Math.min(height[left],height[right]);
            int area=width*ht;
            //update maxarea
            maxArea=Math.max(maxArea,area);

            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
         }
         return maxArea;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of array");
        int n=sc.nextInt();
        int[]height=new int[n];

        System.out.println("enter the height of container:");
        for(int i=0;i<n;i++){
            height[i]=sc.nextInt();
        }
        sc.close();
        int result=Water(height);
        System.out.println(result);
    }
}
