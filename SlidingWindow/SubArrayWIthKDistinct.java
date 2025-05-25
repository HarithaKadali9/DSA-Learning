class SubArrayWIthKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
       return subArrayCount(nums, k)-subArrayCount(nums, k-1);
    }
    public int subArrayCount(int[] nums, int k){
         int count=0, l=0, r=0;
        Map<Integer, Integer> map=new HashMap<>();
        while(r<nums.length){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            while(map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            count=count+(r-l+1);
            r++;
        }
        return count;
    }
}

/**
Time Limit Exceeded
45 / 57 testcases passed
public int subarraysWithKDistinct(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            Map<Integer, Integer> map=new HashMap<>();
            for(int j=i;j<nums.length;j++){
                map.put(nums[j], map.getOrDefault(nums[j], 0)+1);
                if(map.size()>k) break;
                if(map.size()==k) count++;
            }
        }
        return count;
    }
 */