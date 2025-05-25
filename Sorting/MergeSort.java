class MergeSort{
    public static void mergeSort(int arr[], int l, int r){
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, r);
            merging(arr, l, mid, r);
        }
        
    }
    public static void merging(int res[], int l, int mid, int r){
        int n1=mid-l+1, n2=r-mid;
        int left[]=new int[n1];
        int right[]=new int[n2];
        for(int i=0;i<n1;i++){
            left[i]=res[l+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=res[mid+1+i];
        }
        int i=0, j=0, k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                res[k++]=left[i++];
            }
            else{
                res[k++]=right[j++];
            }
        }
        while(i<n1){
            res[k++]=left[i++];
        }
        while(j<n2){
            res[k++]=right[j++];
        }
    }
    public static void main(String args[]){
        int arr[]={64, 25, 12, 22, 11};
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted array");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}