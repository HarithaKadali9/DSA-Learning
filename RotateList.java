public class RotateList {
    public static ListNode rotateLinkedList(ListNode head, int k) {
        if(head==null) return head;
        if(k<0) {
            System.out.println("Please enter valid k");
            return null;
        }
        ListNode tail=head, temp=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        System.out.println("len: "+len);
        if(k%len==0) return head;
        k=k%len;
        int count1=1;
        while(temp!=null){
            if(count1==len-k){
                tail.next=head;
                head=temp.next;
                temp.next=null;
                System.out.println("count: "+count1);
                break;
            }
            count1++;
            temp=temp.next;
        }
        return head;
    }
    private static ListNode convertList(int[] arr){
        if(arr.length==0) return null;
        ListNode head=new ListNode(arr[0]);
        ListNode current=head;
        for(int i=1;i<arr.length;i++){
            ListNode newNode=new ListNode(arr[i]);
            current.next=newNode;
            current=newNode;
        }
        return head;
    }
    private static void printNode(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
    public static void main(String args[]){
        int arr[]={1, 2, 3, 4, 5};
        int k=16;
        ListNode head;
        head=convertList(arr);
        printNode(head);
        head=rotateLinkedList(head, k);
        System.out.println("After Rotating");
        printNode(head);
    }
    
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
