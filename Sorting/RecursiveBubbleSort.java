// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.ArrayList;

class RecursiveBubbleSort {
    private static void recursiveBubbleSort(int ind, int arr[]){
        if(ind==arr.length) return;
        for(int i=ind;i<arr.length;i++){
             if(arr[i]<arr[ind]){
                 int temp=arr[i];
                 arr[i]=arr[ind];
                 arr[ind]=temp;
             }
        }
        recursiveBubbleSort(ind+1, arr);
    }
    public static void main(String[] args) {
        int arr[]={7, 8, 1, 4, 6, 5, 9};
        System.out.println("Before calling recursion");
        for(int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
        recursiveBubbleSort(0, arr);
        System.out.println("After calling recursion");
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}