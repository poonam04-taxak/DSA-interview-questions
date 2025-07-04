
import java.util.*;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> triangle=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer>row=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i){
                    row.add(1);
                }
                else{
                    int val=triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j);
                    row.add(val);
                }
            }
            triangle.add(row);
        } 
        return triangle;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the number of rows for Pascal's Triangle:");
        int numRows = sc.nextInt();
        sc.close();

        List<List<Integer>> result = generate(numRows);

        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
