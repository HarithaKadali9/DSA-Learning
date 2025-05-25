class 3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1, k=nums.length-1;
            while(j<k){
                long sum=nums[i]+nums[j]+nums[k];
                if(sum<0)j++;
                else if(sum>0) k--;
                else if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(k<nums.length-1 && j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return res;
    }
}
/**
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0 && i!=j && i!=k && j!=k){
                        List<Integer> arr1=new ArrayList<>();
                        arr1.add(nums[i]);
                        arr1.add(nums[j]);
                        arr1.add(nums[k]);
                        if(!arr.contains(arr1)){
                            arr.add(arr1);
                        }
                    }
                }
            }     
        }
        return arr;
    }
}
 */