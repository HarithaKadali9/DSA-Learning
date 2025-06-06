import java.util.List;
import java.util.ArrayList;
class SubsequencePrint{
    private static void subsequence(int ind, List<Integer> list, int[] arr, int n){
        if(ind==n){
            for(int i : list){
                System.out.print(i+" ");
            }
            if(list.size()==0) System.out.print("{}");
            System.out.println();
            return;
        }
        list.add(arr[ind]);
        subsequence(ind+1, list, arr, n);
        list.remove(list.size()-1);
        subsequence(ind+1, list, arr, n);
    }
    public static void main(String[] args){
        int arr[]={3, 1, 2};
        int n=arr.length;
        subsequence(0, new ArrayList<>(), arr, n);
    }
}

/**
 * 
 * class Solution {
    private static List<List<Integer>> generateSubsets(int ind, int nums[], List<List<Integer>> res, List<Integer> list){
        
        if(ind==nums.length) {
            res.add(new ArrayList<>(list));
            return res;
        }

        list.add(nums[ind]);
        generateSubsets(ind+1, nums, res, list);

        list.remove(list.size()-1);
        generateSubsets(ind+1, nums, res, list);

        return res;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res=generateSubsets(0, nums, res, new ArrayList<>());
        return res;
    }
}

 */