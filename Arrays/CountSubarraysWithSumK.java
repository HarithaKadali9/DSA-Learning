class CountSubarraysWithSumK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        int sum=0, count=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)) count+=map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
/**
Runtime1079ms Beats25.01%
public int subarraySum(int[] nums, int k) {
        int n=nums.length, count=0;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }
 */

/**
if(n==0) return 0;
        if(n==1 && k<nums[0]) return 1;
        int l=0, r=0, count=0, sum=0;
        while(r<nums.length){
            sum+=nums[r];
            if(sum>k){
                sum-=nums[l];
            }
            if(sum==k){
                sum=0;
                count++;
                sum+=nums[r];
                l++;
            }
            
            r++;
        }
        return count;
 */