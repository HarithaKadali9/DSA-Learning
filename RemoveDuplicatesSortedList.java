

class RemoveDuplicatesSortedList {
    public static ListNode removeDuplicates(ListNode head) {
         if(head==null || head.next==null) return head;
         ListNode temp=head;
         while(temp!=null && temp.next!=null){
             if(temp.val==temp.next.val){
                temp.next=temp.next.next;
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
        int arr[]={1,1,1,2,2, 3,3,4,4,5,6,7};
        ListNode head;
        head=convertList(arr);
        System.out.println("Before Removing Duplicates");
        printNode(head);
        head=removeDuplicates(head);
        System.out.println("After Removing Duplicates");
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