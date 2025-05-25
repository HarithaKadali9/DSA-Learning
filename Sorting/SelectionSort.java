class SelectionSort{
    public static void selectionSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            boolean flag=false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<=arr[min]){
                    min=j;
                    flag=true;
                }
            }
            if(flag==true){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }
    public static void main(String args[]){
        int arr[]={64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println("Sorted array");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}