class Node{
    int data;
    Node next;
    Node(int data, Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedList{
    private static Node convertArrToList(int[] arr){
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=newNode;
        }
        return head;
    }
    private static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    private static Node deleteNode(Node head){
        if(head==null || head.next==null) return null;
        head=head.next;
        return head;
    }
    private static Node deleteTail(Node head){
        if(head==null || head.next==null) return null;
        Node temp=head;
        Node prev=null;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return head;
    }
    private static Node deleteKthNode(Node head, int k){
        if(head==null){
            if(k==1) return null;
            else{
                System.out.println("k value should be less than number of nodes");
                return null;
            }
        }
        if(k==1){ 
            head=head.next;
            return head;
        }
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k-1)break;
            temp=temp.next;
        }
        temp.next=temp.next.next;

        return head;
    }
    private static Node deleteNodeByValue(Node head, int val){
        if(head==null){
            return null;
        }
        if(head.data==val){
            head=head.next;
            return head;
        }
        Node temp=head, prev=null;
        while(temp.next!=null){
            if(temp.next.data==val)break;
            prev=temp;
            temp=temp.next;
        }
        prev.next=prev.next.next;
        return head;
    }
    public static void main(String[] arsgs){
        int[] arr={12};
        Node head;
        head=convertArrToList(arr);
        head=deleteNodeByValue(head,12);
        print(head);
    }
}