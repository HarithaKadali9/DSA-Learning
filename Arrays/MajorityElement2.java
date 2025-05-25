class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int ele1=0, cnt1=0;
        int ele2=0, cnt2=0;
        for(int i=0;i<nums.length;i++){
            if(cnt1==0 && nums[i]!=ele2){
                ele1=nums[i];
                cnt1=1;
            }
            else if(cnt2==0 && nums[i]!=ele1){
                ele2=nums[i];
                cnt2=1;
            }
            else if(ele1==nums[i]) cnt1++;
            else if(ele2==nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0; cnt2=0;
        int mini=(int)(nums.length/3)+1;
        for(int i=0;i<nums.length;i++){
            if(ele1==nums[i]) cnt1++;
            else if(ele2==nums[i]) cnt2++;
        }
        if(cnt1>=mini) ans.add(ele1);
        if(cnt2>=mini) ans.add(ele2);
        return ans;
    }
}

/**
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> arr=new ArrayList<>();
        int n=nums.length,k=n/3,count=1;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int c=entry.getValue();
            int e=entry.getKey();
            if(c>k){
                arr.add(e);
            }
        }
        return arr;
    }
}
 */

/**
public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
            if(cnt>(int)(n/3) && !ans.contains(nums[i])) ans.add(nums[i]);
        }
        return ans;
    }
 */