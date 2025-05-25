import java.util.List;
import java.util.ArrayList;
class PrintPascalTriangle{
    public static List<Integer> generateNthRow(int row){
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        int res=1;
        for(int i=0;i<row;i++){
            res=res*(row-i);
            res/=(i+1);
            temp.add(res);
        }
        return temp;
    }
    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ans.add(generateNthRow(i));
        }
        return ans;
    }
    public static void main(String args[]){
        int row=10;
        List<List<Integer>> res=pascalTriangle(row);
        System.out.println("Nth row: "); 
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

/**
 * import java.util.List;
import java.util.ArrayList;
class PrintPascalTriangle{
    public static int rowColElement(int row, int col){
        int res=1;
        for(int i=0;i<col;i++){
            res=res*(row-i);
            res/=(i+1);
        }
        return res;
    }
    public static List<List<Integer>> pascalTriangle(int n){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            List<Integer> arr=new ArrayList<>();
            for(int j=1;j<=i;j++){
                arr.add(rowColElement(i-1, j-1));
            }
            ans.add(arr);
        }
        return ans;
    }
    public static void main(String args[]){
        int row=10;
        List<List<Integer>> res=pascalTriangle(row);
        System.out.println("Nth row: "); 
        for(List<Integer> list : res){
            for(int i : list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
 */