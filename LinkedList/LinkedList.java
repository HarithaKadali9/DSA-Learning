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
        if(arr.length==0) return null;
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
    private static int length(Node head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
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
    private static Node insertAtHead(Node head, int val){
        if(head==null){
            return new Node(val);
        }
        Node newNode=new Node(val, head);
        //newNode.next=head;
        head=newNode;
        return head;
    }
    private static Node insertAtTail(Node head, int val){
        if(head==null){
            return new Node(val);
        }
        Node temp=head;
        while(temp.next!=null) temp=temp.next;
        Node newNode=new Node(val, null);
        temp.next=newNode;
        return head;
    }
    private static Node insertAtK(Node head, int val, int k){
        if(head==null){
            if(k==1) return new Node(val);
        }
        if(k>length(head)) {
            System.out.println("Please enter k below the number of nodes");
            return null;
        }
        if(k==1) return insertAtHead(head, val);
        int count=0;
        Node temp=head;
        while(temp.next!=null){
            count++;
            if(count==k-1)break;
            temp=temp.next;
        }
        Node newNode=new Node(val, temp.next);
        temp.next=newNode;
        return head;
    }
    private static Node insertBeforeValue(Node head, int val, int ele){
        if(head==null){
            System.out.println("It is not existing because if u want to insert before value then u must have to have a node");
            return null;
        }
        if(head.data==ele){
            return insertAtHead(head, val);
        }
        Node temp=head;
        Node prev=null;
        boolean flag=false;
        while(temp.next!=null){
            if(temp.data==ele){
                flag=true;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        if(!flag){
            System.out.println("Element not found But i am inserting at tail");
            return insertAtTail(head, val);
        }
        Node newNode=new Node(val, temp);
        prev.next=newNode;
        return head;
    }
    public static void main(String[] arsgs){
        int[] arr={12, 5, 8, 7};
        Node head;
        head=convertArrToList(arr);
        head=insertBeforeValue(head,100, 4);
        print(head);
    }
}