import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class CombinationSumTwo{
    private static void combinationSum(int arr[], int target){
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0, arr, target, ans, new ArrayList<>());
        for(List<Integer> list : ans){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    private static void findCombinations(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            if(i>ind && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            ds.add(arr[i]);
            findCombinations(i+1, arr, target-arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    public static void main(String[] args){
        int arr[]={1, 1, 1, 2, 2};
        int target=4;
        Arrays.sort(arr);
        combinationSum(arr, target);
    }
}