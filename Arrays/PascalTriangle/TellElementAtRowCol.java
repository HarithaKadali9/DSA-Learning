class TellElementAtRowCol{
    public static int rowColElement(int row, int col){
        int res=1;
        for(int i=0;i<col;i++){
            res=res*(row-i);
            res/=(i+1);
        }
        return res;
    }
    public static void main(String args[]){
        int row=2, col=1;
        //ncr
        int ans=rowColElement(row-1, col-1);
        System.out.println("Answer: "+ans);
    }
}

/**
 * TC: O(r)+O(c)+O(r-c)
 * public static int findFactorial(int n){
        if(n==0 || n==1) return 1;
        return n*findFactorial(n-1);
    }
    public static int rowColElement(int row, int col){
        if(row==col) return 1;
        int numerator=findFactorial(row);
        int d1=findFactorial(col);
        int d2=findFactorial(row-col);
        int ans=numerator/(d1*d2);
        return ans;
    }
 */