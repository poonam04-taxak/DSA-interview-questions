import java.util.*;
public class CobinationSum {
    public static List<List<Integer>> sum(int[]candidate,int target){
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidate,target,0,new ArrayList<>(),result);
        return result;
    }
    public static void backtrack(int[]candidate,int target,int start,List<Integer>curr,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(curr));
        }
        if(target<0){
            return ;//invalid path
        }
        for(int i=start;i<candidate.length;i++){
            curr.add(candidate[i]);
            backtrack(candidate,target-candidate[i],i,curr,result);// i (not i+1) for reuse
            curr.remove(curr.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] candidate={2,3,6,7};
        int target=7;
        List<List<Integer>> ans=sum(candidate,target);
        System.out.println(ans);
    }
}
