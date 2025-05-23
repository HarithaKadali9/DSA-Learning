import java.util.Map;
import java.util.HashMap;
class FruitsIntoBasket{
    private static int fruitsBasket(int arr[], int k){
        Map<Integer, Integer> map=new HashMap<>();
        int l=0, r=0, maxlen=0;
        while(r<arr.length){
             map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            if(map.size()>k){
                while(map.size()>k){
                    map.put(arr[l], map.get(arr[l])-1);
                    if(map.get(arr[l])==0) map.remove(arr[l]);
                    l++;
                }
            }
            if(map.size()<=k) maxlen=Math.max(r-l+1, maxlen);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args){
        int arr[]={3, 3, 3, 1, 2, 1, 2, 3, 3, 4};
        int k=2;
        int maxFruits=fruitsBasket(arr, k);
        System.out.println("Maximum fruits count which allows atmost 2 types of fruits: "+maxFruits);
    }
}

/**
 * TC=O(n*n) SC=O(3)
 * private static int fruitsBasket(int arr[], int k){
        int maxcount=0;
        for(int i=0;i<arr.length;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i;j<arr.length;j++){
                set.add(arr[j]);
                if(set.size()>k) break;
                if(set.size()<=k){
                    // if(map.containsKey(arr[j])){
                    //     map.put(arr[j], map.get(arr[j])+1);
                    // }
                    
                    maxcount=Math.max(j-i+1, maxcount);
                }
            }
        }
        return maxcount;
    }
 */