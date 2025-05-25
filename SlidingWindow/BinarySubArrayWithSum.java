class BinarySubArrayWithSum {
    public int subArrayCount(int[] nums, int goal){
        //Runtime1ms Beats100.00%

        if(goal<0) return 0;
        int count=0, l=0, r=0, sum=0;
        while(r<nums.length){
            sum+=nums[r];
            while(sum>goal){
                sum-=nums[l];
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subArrayCount(nums, goal)-subArrayCount(nums, goal-1);
    }
}

/**
Runtime 1177 ms
Beats 12.15%
public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0, sum=0;
        for(int i=0;i<nums.length;i++){
            sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum>goal) break;
                if(sum==goal)count++;
            }
        }
        return count;
    }
 */