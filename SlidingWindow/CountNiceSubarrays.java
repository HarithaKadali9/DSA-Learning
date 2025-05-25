class CountNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        return subArrayCount(nums, k)-subArrayCount(nums, k-1);
    }
    public int subArrayCount(int[] nums, int k){
        if(k<0) return 0;
        int count=0, l=0, r=0, sum=0;
        while(r<nums.length){
            sum+=nums[r]%2;
            while(sum>k){
                sum-=nums[l]%2;
                l++;
            }
            count+=r-l+1;
            r++;
        }
        return count;
    }
}