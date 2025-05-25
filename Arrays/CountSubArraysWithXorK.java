import java.util.Map;
import java.util.HashMap;
class CountSubArraysWithXorK{
    private static int countXorK(int[] arr,int k){
        Map<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int count=0, xr=0;
        for(int i=0;i<arr.length;i++){
            xr=xr^arr[i];
            int x=xr^k;
            if(map.containsKey(x))count+=map.get(x);
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        return count;
    }
    public static void main(String args[]){
        int arr[]={4, 2, 2, 6, 4};
        int k=6;
        int res=countXorK(arr, k);
        System.out.println("Count: "+res);
    }
}

/**
 * TC=O(n*n)
 * private static int countXorK(int[] arr,int k){
        int count=0, xor=0;
        for(int i=0;i<arr.length;i++){
            xor=0;
            for(int j=i;j<arr.length;j++){
                xor=xor^arr[j];
                if(xor==k) count++;
            }
        }
        return count;
    }
 */