class FirstNNumberSum {
    private static int nNumberSum(int n, int sum){
        if(n==0) return sum;
        return nNumberSum(n-1, sum+n);
    }
    public static void main(String[] args) {
        int n=2;
        int res=nNumberSum(n, 0);
        System.out.println("Sum of first n numbers using recursion: "+ res);
    }
}