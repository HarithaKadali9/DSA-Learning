import java.util.List;
import java.util.ArrayList;
class CombinationSum{
    private static void findCombinations(int ind, List<List<Integer>> res, List<Integer> list, int arr[], int target, int n){
        if(ind==n){
            if(target==0){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[ind]<=target){
            list.add(arr[ind]);
            findCombinations(ind, res, list, arr, target-arr[ind], n);
            list.remove(list.size()-1);
        }
        findCombinations(ind+1, res, list, arr, target, n);
    }
    public static void main(String[] args){
        int arr[]={2, 3, 6, 7};
        int target=7;
        List<List<Integer>> ans=new ArrayList<>();
        findCombinations(0, ans, new ArrayList<>(), arr, target, arr.length);
        for(List<Integer> list : ans){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}