class CountSubsequenceSumK{
    private static int countSum(int ind, int arr[], int sum, int target, int n){
        if(ind==n){
            if(sum==target) return 1;
            return 0;
        }
        sum+=arr[ind];
        int l=countSum(ind+1, arr, sum, target, n);

        sum-=arr[ind];
        int r=countSum(ind+1, arr, sum, target, n);
        return l+r;
    }
    public static void main(String[] args){
        int arr[]={3, 1, 2};
        int target=3;
        int n=arr.length;
        System.out.println("Count subsequence with sum target: "+countSum(0, arr, 0, target, n));
    }
}