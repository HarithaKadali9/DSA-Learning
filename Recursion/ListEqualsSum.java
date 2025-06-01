import java.util.List;
import java.util.ArrayList;
class ListEqualsSum{
    private static void printSum(int ind, List<Integer> list, int sum, int target, int[] arr, int n){
        if(ind==n){
            if(sum==target){
                for(int i : list) System.out.print(i + " ");
                System.out.println();
            }
            return;
        }
        list.add(arr[ind]);
        sum+=arr[ind];
        printSum(ind+1, list, sum, target, arr, n);
        
        list.remove(list.size()-1);
        sum-=arr[ind];
        printSum(ind+1, list, sum, target, arr, n);
    }
    public static void main(String[] args){
        int arr[]={1, 2, 1};
        int target=2;
        int n=arr.length;
        printSum(0, new ArrayList<>(), 0, target, arr, n);
    }
}