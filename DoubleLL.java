import java.util.Stack;
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
    private static int length(Node head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    private static Node deleteHead(Node head){
        if(head==null || head.next==null) return null;
        head=head.next;
        head.prev=null;
        return head;
    }
    private static void printDLL(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    private static Node deleteTail(Node head){
        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node back=temp.prev;
        back.next=null;
        return head;
    }
    private static Node deleteKthNode(Node head, int k){
        if(head==null){
            System.out.println("Previously there are no nodes so its not possible to delete a node");
            return null;
        }
        if(k<1){
            System.out.println("Please enter k greater than 1 only");
            return null;
        }
        if(k>length(head)){
            System.out.println("Please enter k less than number of nodes only \nNumber of nodes: "+length(head));
            return null;
        }
        int count=0;
        Node temp=head;
        while(temp.next!=null){
            count++;
            if(count==k) break;
            temp=temp.next;
        }
        Node back=temp.prev;
        Node front=temp.next;
        
        if(back==null && front==null){
            System.out.println("one node is deleted");
            return null;
        };
        if(back==null) return deleteHead(head);
        if(front==null) return deleteTail(head);
        
        back.next=front;
        front.prev=back;
        
        temp.prev=null;
        temp.next=null;
        return head;
    }
    private static Node deleteNodeByValue(Node head, int ele){
        if(head==null){
            System.out.println("No nodes present");
            return null;
        }
        //if(head.data==ele) return deleteHead(head);
        Node temp=head;
        boolean flag=false;
        while(temp!=null){
            if(temp.data==ele) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
            System.out.println("Element not found");
            return null;
        }
        Node back=temp.prev;
        Node front=temp.next;

        if(back==null && front==null){
            System.out.println("One node deleted \nNumber of elements: 0");
            return null;
        }
        if(back==null) return deleteHead(head);
        if(front==null)return deleteTail(head);

        back.next=front;
        front.prev=back;

        temp.next=null;
        temp.prev=null;
        return head;
    }
    
    private static Node insertBeforeHead(Node head, int val){
        if(head==null) return new Node(val);
        Node newNode=new Node(val, null, head);
        head=newNode;
        return head;
    }
    private static Node insertBeforeTail(Node head, int val){
        if(head==null) return new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        Node back=temp.prev;
        Node newNode=new Node(val, back, temp);
        back.next=newNode;
        // newNode.next=temp;
    
        return head;
    }
    private static Node insertAtK(Node head, int val, int k){
        if(head==null){
            if(k==1) return insertBeforeHead(head, val);
            else{
                System.out.println("Since there are no nodes but i am still adding this node as a head");
                return insertBeforeHead(head, val);
            }
        }
        if(k<1){
            System.out.println("please enter k greater than 1");
            return null;
        }
        if(k>length(head)){
            System.out.println("please enter k less than number of nodes");
            return null;
        }
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }
        Node back=temp.prev;
        Node front=temp.next;

        if(back==null && front==null) return new Node(val);
        if(back==null) return insertBeforeHead(head, val);
        if(front==null) return insertAfterTail(head, val);

        Node newNode=new Node(val);
        newNode.next=front;
        back.next=newNode;
        return head;
    }
    private static Node insertAfterTail(Node head, int val){
        if(head==null) return new Node(val);
        Node temp=head;
        while(temp.next!=null)temp=temp.next;
        //Node back=temp.prev;
        Node newNode=new Node(val);
        temp.next=newNode;
        newNode.next=null;
        return head;
    }
    private static Node insertBeforeValue(Node head, int val, int ele){
        if(head==null){
            System.out.println("Since there are no nodes so cant insert");
            return null;
        }
        Node temp=head;
        boolean flag=false;
        while(temp!=null){
            if(temp.data==ele) {
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if(!flag){
            System.out.println("Element not found so cant insert");
            return null;
        }
        Node back=temp.prev;
        if(back==null) return insertBeforeHead(head, val);
        Node newNode=new Node(val);
        back.next=newNode;
        newNode.next=temp;
        return head;
    }
    private static Node reverseDoubleLL(Node head){
        if(head==null || head.next==null) return head;
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            prev=temp.prev;
            temp.prev=temp.next;
            temp.next=prev;
            temp=temp.prev;
        }
        return prev.prev;
        /**
        if(head==null || head.next==null) return head;
        Stack<Integer> stack=new Stack<>();
        Node temp=head;
        while(temp!=null){
            stack.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.data=stack.pop();
            temp=temp.next;
        }
        return head;
         */
    }
    public static void main(String args[]){
        int arr[]={12, 5, 8, 7};
        Node head;
        head=convertArrToDLL(arr);
        head=reverseDoubleLL(head);
        printDLL(head);
    }
}
