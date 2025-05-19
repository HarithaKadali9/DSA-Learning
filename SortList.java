class SortList {
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //Dutch National Flag algorithm
        // O(n) time and O(1) space
        ListNode zerohead=new ListNode(-1);
        ListNode onehead=new ListNode(-1);
        ListNode twohead=new ListNode(-1);
        ListNode zero=zerohead, one=onehead, two=twohead, temp=head;
        while(temp!=null){
            if(temp.val==0){
                zero.next=temp;
                zero=zero.next;
            }
            else if(temp.val==1){
                one.next=temp;
                one=one.next;
            }
            else if(temp.val==2){
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=(onehead.next!=null) ? onehead.next : twohead.next;
        one.next=twohead.next;
        two.next=null;
        return zerohead.next;
        /**
        int c0=0, c1=0, c2=0;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val==0) c0++;
            if(temp.val==1) c1++;
            if(temp.val==2) c2++;
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
             if(c0>0){
                temp.val=0;
                c0--;
            }
            else if(c1>0){
                temp.val=1;
                c1--;
            }
            else if(c2>0){
                temp.val=2;
                c2--;
            }
            temp=temp.next;
        }
        return head;
         */
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
        int arr[]={1,1,1,0};
        ListNode head;
        head=convertList(arr);
        System.out.println("Before Sorting");
        printNode(head);
        head=sortList(head);
        System.out.println("After Sorting");
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
