class PrintOneToN {
    private static void printOneToN(int ind, int n){
        if(ind==n+1) return;
        System.out.print(ind+" ");
        printOneToN(ind+1, n);
    }
    public static void main(String[] args) {
        System.out.println("Printing 1 to n using recursion: ");
        int n=10;
        printOneToN(1,n);
    }
}