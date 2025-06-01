import java.util.*;
class SubsetSumTwo{
    private static void subset(int arr[]){
        List<List<Integer>> ans=new ArrayList<>();
        subsetSum(0, arr, ans, new ArrayList<>());
        for(List<Integer> list : ans){
            System.out.print("[");
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.print("], ");
        }
    }
    private static void subsetSum(int ind, int arr[], List<List<Integer>> ans, List<Integer> list){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            subsetSum(i+1, arr, ans, list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args){
        int arr[]={1, 2, 2, 2, 3, 3};
        Arrays.sort(arr);
        subset(arr);
    }
}