import java.util.List;
import java.util.ArrayList;
class PrintAnyOneSusequence{
    private static boolean subsequence(int ind, List<Integer> list, int arr[], int target, int n){
        if(ind==n){
            if(target==0){
                for(int i : list){
                    System.out.print(i+" ");
                }
                return true;
            }
            return false;
        }
        
        if(arr[ind]<=target){
            list.add(arr[ind]);
            if(subsequence(ind+1, list, arr, target-arr[ind], n)==true) return true;
            list.remove(list.size()-1);
        } 
        if(subsequence(ind+1, list, arr, target, n)==true) return true;
        return false;
    }
    public static void main(String[] args){
        int arr[]={1, 2, 1};
        int target=2;
        int n=arr.length;
        subsequence(0, new ArrayList<>(), arr, target, n);
    }
}