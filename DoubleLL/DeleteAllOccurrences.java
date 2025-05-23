


class DeleteAllOccurrences {
    public static ListNode deleteAllOccurrences(ListNode head, int target){
        ListNode temp=head;
        ListNode nextNode=null, prevNode=null;
        while(temp!=null){
            if(temp.val==target){
                if(temp==head)head=head.next;
                nextNode=temp.next;
                prevNode=temp.prev;
                if(nextNode!=null) nextNode.prev=prevNode;
                if(prevNode!=null) prevNode.next=nextNode;
                temp=nextNode;
            }
            else{
                temp=temp.next;
            }
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
            newNode.prev=current;
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
        int arr[]={10, 4, 10, 10, 6, 10};
        int target=10;
        ListNode head;
        head=convertList(arr);
        head=deleteAllOccurrences(head, target);
        System.out.println("After deleting occurences");
        printNode(head);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
