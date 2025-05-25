class 4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k=j+1, l=nums.length-1;
                while(k<l){
                    long sum=nums[i]+nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum==target){
                        List<Integer> arr=Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        res.add(arr);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(l<nums.length && k<l && nums[l]==nums[l+1]) l--;
                    } 
                    else if(sum<target) k++;
                    else if(sum>target) l--;
                }
            }
        }
        return res;
    }
}
/**
Wrong Answer 197 / 294 testcases passed
public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> set=new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum=nums[i]+nums[j]+nums[k];
                    long total=target-sum;
                    if(set.contains((int)total)){
                        List<Integer> arr=Arrays.asList(nums[i], nums[j], nums[k], (int)total);
                        if(!res.contains(arr)) res.add(arr);
                    }
                    set.add(nums[k]);
                }
            }
        }
        return res;
    }
 */

/**
Wrong Answer
194 / 294 testcases passed

Editorial
Input
nums =
[-5,5,4,-3,0,0,4,-2]
target =
4

Use Testcase
Output
[[-5,5,4,0],[-5,5,0,4],[5,4,-3,-2],[5,-3,4,-2]]
Expected
[[-5,0,4,5],[-3,-2,4,5]]
public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                            List<Integer> arr=Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            if(!res.contains(arr)) res.add(arr);
                        }
                    }
                }
            }
        }
        return res;
    }
 */