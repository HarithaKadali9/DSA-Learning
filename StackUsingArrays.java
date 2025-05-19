class Stack{
    int top;
    int arr[];
    int size;
    Stack(int size){
        this.size=size;
        this.top=-1;
        arr=new int[size];
    }
    
}
class StackUsingArrays{
    private static int length(Stack s){
        int count=0;
        while(s.top!=-1){
            count++;
            s.pop();
        }
        return count;
    }
    private static void push(Stack s, int ele){
        int k=length(s);
        if(k<size){
            top++;
            s[top]=ele;
        }
        else{
            System.out.println("Stack Overflow");
        }
    }
    private static int pop(Stack s){
        if(top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        top=top-1;
        return s.top;
    }
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the size of stack");
        int size=s.nextInt();
        System.out.println("Enter the size of stack");
        int option=s.nextInt();
        while(option){
            switch(option){
                case 1:
                    System.out.println("Enter the element to be pushed");
            }
        }
    }
}