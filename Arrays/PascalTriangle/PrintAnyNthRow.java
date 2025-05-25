class PrintAnyNthRow{
    public static int rowColElement(int row, int col){
        int res=1;
        for(int i=0;i<col;i++){
            res=res*(row-i);
            res/=(i+1);
        }
        return res;
    }
    public static int[] nthRow(int row){
        int arr[]=new int[row];
        for(int i=1;i<=row;i++){
            arr[i-1]=rowColElement(row-1, i-1);
        }
        return arr;
    }
    public static void main(String args[]){
        int row=2;
        int ans[]=nthRow(row);
        System.out.println("Nth row: "); 
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}