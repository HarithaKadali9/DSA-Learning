class PrintNTimes {
    private static void printNTimes(int n){
        if(n==0) return;
        System.out.println("Haritha");
        printNTimes(n-1);
    }
    public static void main(String[] args) {
        System.out.println("Printing n times: ");
        int n=4;
        printNTimes(n);
    }
}