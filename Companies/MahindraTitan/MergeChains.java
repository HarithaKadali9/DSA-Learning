// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.List;
import java.util.ArrayList;

class MergeChains {
    private static Node convertArr(int[] arr){
        if(arr.length==0) return null;
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=temp.next;
        }
        return head;
    }
    private static Node convertSetToList(List<Integer> set){
        Node dummy=new Node(-1);
        Node temp=dummy;
        for(int i : set){
            Node newNode=new Node(i);
            temp.next=newNode;
            temp=temp.next;
        }
        return dummy.next;
    }
    private static Node mergeChain(Node head1, Node head2){
        List<Integer> list=new ArrayList<>();
        Node head;
        if(head1.data<head2.data){
            while(head1!=null) {
                if(!list.contains(head1.data)) list.add(head1.data);
                head1=head1.next;
            }
            while(head2!=null) {
                if(!list.contains(head2.data)) list.add(head2.data);
                head2=head2.next;
            }
            head=convertSetToList(list);
        }
        else{
            while(head2!=null) {
                if(!list.contains(head2.data)) list.add(head2.data);
                head2=head2.next;
            }
            while(head1!=null) {
                if(!list.contains(head1.data)) list.add(head1.data);
                head1=head1.next;
            }
            
            head=convertSetToList(list);
        }
        return head;
    }
    private static void printHead(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static void main(String[] args) {
        int arr2[]={54, 12, 36, 48, 56, 67, 78};
        int arr1[]={46, 56, 67, 78};
        //output linkedlist: 1, 12, 36, 48, 56, 67, 78, 46
        Node head1=convertArr(arr1);
        Node head2=convertArr(arr2);
        Node head=mergeChain(head1, head2);
        printHead(head);
    }
}
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

/**
 * 
 * private static Node mergeChain(Node head1, Node head2){
        int l1=findLength(head1);
        int l2=findLength(head2);
        Node res=null;
        Node p1=head1, p2=head2;
        while(l1>l2){
            p1=p1.next;
            l1--;
        }
        while(l2>l1){
            p2=p2.next;
            l2--;
        }
        Node p1prev=null, p2prev=null;
        while(p1.data!=p2.data){
            p1prev=p1;
            p2prev=p2;
            p1=p1.next;
            p2=p2.next;
        }
        Node curr=p1, curr2=p2;
        if(head1.data<head2.data){
            p2prev.next=null;
            while(p1.next!=null){
                p1=p1.next;
            }
            p1.next=head2;
            res=head1;
        }
        else{
            p1prev.next=null;
            while(p2.next!=null){
                p2=p2.next;
            }
            p2.next=p1prev;
            res=head2;
        }
        return res;
    }

 */

/**
 *    
   private static Node mergeChain(Node head1, Node head2) {
        // Handle null cases
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        // Special case: if both heads are the same node
        if (head1 == head2) return head1;
        
        int l1 = findLength(head1);
        int l2 = findLength(head2);
        Node p1 = head1, p2 = head2;
        
        // Align pointers
        while (l1 > l2) {
            p1 = p1.next;
            l1--;
        }
        while (l2 > l1) {
            p2 = p2.next;
            l2--;
        }
        
        // Find merge point
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        
        // No merge point found
        if (p1 == null || p2 == null) {
            return null;
        }
        
        Node mergePoint = p1;
        
        // Special case: merge point is one of the heads
        if (mergePoint == head1) {
            // Find tail of head2's independent part and connect to head1
            Node tail2 = head2;
            while (tail2.next != mergePoint) {
                tail2 = tail2.next;
            }
            tail2.next = null;
            
            Node tailOfHead1 = head1;
            while (tailOfHead1.next != null) {
                tailOfHead1 = tailOfHead1.next;
            }
            tailOfHead1.next = head2;
            return head1;
        }
        
        if (mergePoint == head2) {
            // Similar logic for head2
            Node tail1 = head1;
            while (tail1.next != mergePoint) {
                tail1 = tail1.next;
            }
            tail1.next = null;
            
            Node tailOfHead2 = head2;
            while (tailOfHead2.next != null) {
                tailOfHead2 = tailOfHead2.next;
            }
            tailOfHead2.next = head1;
            return head2;
        }
        
        // Normal case: merge point is in middle
        Node prev1 = null, prev2 = null;
        Node curr1 = head1, curr2 = head2;
        
        while (curr1 != mergePoint) {
            prev1 = curr1;
            curr1 = curr1.next;
        }
        
        while (curr2 != mergePoint) {
            prev2 = curr2;
            curr2 = curr2.next;
        }
        
        Node res;
        if (head1.data <= head2.data) {
            if (prev2 != null) prev2.next = null;
            p1 = head1;
            while (p1 != null && p1.next != null) {
                p1 = p1.next;
            }
            if (p1 != null) p1.next = head2;
            res = head1;
        } else {
            if (prev1 != null) prev1.next = null;
            p2 = head2;
            while (p2 != null && p2.next != null) {
                p2 = p2.next;
            }
            if (p2 != null) p2.next = head1;
            res = head2;
        }
        
        return res;
    }
 */