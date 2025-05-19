/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null || k == 0) return head;
        // if(k<0) {
        //     System.out.println("Please enter valid k");
        //     return null;
        // }
        ListNode tail=head;
        int len=1;
        while(tail.next!=null){
            len++;
            tail=tail.next;
        }
        tail.next=head;
        //System.out.println("len: "+len);
        //if(k%len==0) return head;
        k=k%len;
        //int count1=1;
        ListNode temp=head;
        for(int i=1;i<len-k;i++){
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
        // while(temp!=null){
        //     if(count1==len-k){
        //         head=temp.next;
        //         temp.next=null;
        //         //System.out.println("count: "+count1);
        //         break;
        //     }
        //     count1++;
        //     temp=temp.next;
        // }
        return head;
    }
}
