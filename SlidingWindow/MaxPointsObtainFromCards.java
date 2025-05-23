class MaxPointsObtainFromCards{
    private static int maxPointsFromCards(int arr[], int k){
        int lsum=0, rsum=0, maxSum=0;
        int n=arr.length;
        for(int i=0;i<=k-1;i++){
            lsum+=arr[i];
        }
        maxSum=Math.max(lsum+rsum, maxSum);
        int rightIndex=n-1;
        for(int i=k-1;i>=0;i--){
            lsum-=arr[i];
            rsum+=arr[rightIndex];
            rightIndex--;
            maxSum=Math.max(lsum+rsum, maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args){
        int arr[]={12, 2, 3, 4, 7, 2, 1, 7, 1};
        int k=4;
        int maxSum=maxPointsFromCards(arr, k);
        System.out.println("Maximum points you can obtain from cards: "+maxSum);
    }
}