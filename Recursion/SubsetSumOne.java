import java.util.List;
import java.util.ArrayList;
import java.util.*;
class  SubsetSumOne{
    private static void subset(int arr[]){
        List<Integer> ans=new ArrayList<>();
        subsetSum(0, 0, arr, ans);
        Collections.sort(ans);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
    private static void subsetSum(int ind, int sum, int arr[], List<Integer> ans){
        if(ind==arr.length){
            ans.add(sum);
            return;
        }
        //add element to sum means picking element
        sum+=arr[ind];
        subsetSum(ind+1, sum, arr, ans);

        //not picking element
        sum-=arr[ind];
        subsetSum(ind+1, sum, arr, ans);
    }
    public static void main(String[] args){
        int arr[]={3, 1, 2};
        subset(arr);
    }
}