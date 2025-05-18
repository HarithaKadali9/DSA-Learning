class Node{
    int data;
    Node prev;
    Node next;
    Node(int data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
    Node(int data, Node back, Node next){
        this.data=data;
        this.prev=back;
        this.next=next;
    }
}
public class DoubleLL {
    private static Node convertArrToDLL(int arr[]){
        int n=arr.length;
        if(n==0)return null;
        //if(n==1) return new Node(arr[0]);
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<n;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            newNode.prev=temp;
            temp=newNode;
        }
        return head;
    }
    private static void printDLL(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String args[]){
        int arr[]={12, 5, 8, 7};
        Node head;
        head=convertArrToDLL(arr);
        printDLL(head);
    }
}
