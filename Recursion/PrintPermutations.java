import java.util.List;
import java.util.ArrayList;
class PrintPermutations{
    private static void permutations(int arr[]){
        List<List<Integer>> ans=new ArrayList<>();
        boolean freq[]=new boolean[arr.length];
        findpermutations(ans, new ArrayList<>(), arr, freq);
        for(List<Integer> list : ans){
            System.out.print("[");
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.print("] ");
        }
    }
    private static void findpermutations(List<List<Integer>> ans, List<Integer> list, int arr[], boolean freq[]){
        if(list.size()==arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(!freq[i]){
                freq[i]=true;
                list.add(arr[i]);
                findpermutations(ans, list, arr, freq);
                freq[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
    public static void main(String[] args){
        int arr[]={1, 2, 3};
        permutations(arr);
    }
}