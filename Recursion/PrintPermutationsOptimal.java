import java.util.List;
import java.util.ArrayList;
class PrintPermutationsOptimal{
    private static void permutations(int arr[]){
        List<List<Integer>> ans=new ArrayList<>();
        findpermutations(0, ans, arr);
        for(List<Integer> list : ans){
            System.out.print("[");
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.print("] ");
        }
    }
    private static void findpermutations(int ind, List<List<Integer>> ans, int arr[]){
        if(ind==arr.length){
            List<Integer> list=new ArrayList<>();
            for(int i : arr){
                list.add(i);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i, ind, arr);
            findpermutations(ind+1, ans, arr);
            swap(i, ind, arr);
        }
    }
    private static void swap(int a, int b, int arr[]){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public static void main(String[] args){
        int arr[]={1, 2, 3};
        permutations(arr);
    }
}