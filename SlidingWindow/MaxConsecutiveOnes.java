class MaxConsecutiveOnes{
    private static int maxOnes(int arr[], int k){
        int maxlen=0, n=arr.length, l=0, r=0, zeroes=0;
        while(r<n){
            if(arr[r]==0) zeroes++;
            if(zeroes>k){
                if(arr[l]==0) zeroes--;
                l++;
            }
            maxlen=Math.max(maxlen, r-l+1);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args){
        int arr[]={1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k=2;
        int maxSum=maxOnes(arr, k);
        System.out.println("Maximum Consecutive Ones: "+maxSum);
    }
}

/**
 * TC=O(n*n) SC=O(1)
 * private static int maxOnes(int arr[], int k){
        int maxlen=0, n=arr.length, zeroes;
        for(int i=0;i<n;i++){
            zeroes=0;
            for(int j=i;j<n;j++){
                if(arr[j]==0) zeroes++;
                if(zeroes>k) break;
                maxlen=Math.max(maxlen, j-i+1);
            }
        }
        return maxlen;
    }
 */