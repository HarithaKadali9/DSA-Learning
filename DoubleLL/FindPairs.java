import java.util.HashMap;
import java.util.Map;
public class FindPairs {
    public static Map<Integer, Integer> findPairsLinkedList(ListNode head, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        if(head==null || head.next==null) return map;
        ListNode left=head, right=head;
        while(right.next!=null){
            right=right.next;
        }
        while(left != null && right != null && left != right && left.val < right.val){
            if(left.val+right.val==target){
                map.put(left.val, right.val);
                left=left.next;
                right=right.prev;
            }
            else if(left.val+right.val<target) left=left.next;
            else if(left.val+right.val>target) right=right.prev;
        }
        return map;
        /**
        Map<Integer, Integer> map=new HashMap<>();
        ListNode temp1=head;
        while(temp1!=null){
            ListNode temp2=temp1.next;
            //if(temp2==null) return null;
            //You exit the entire method and return null, throwing away all pairs you already found!
            while(temp2!=null && temp1.val+temp2.val<=target){
                if(temp1.val+temp2.val==target){
                    map.put(temp1.val, temp2.val);
                }
                temp2=temp2.next;
            }
            temp1=temp1.next;
        }
        return map;
         */
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
        int arr[]={1, 2, 3, 4, 9};
        ListNode head;
        int target=5;
        Map<Integer, Integer> map;
        head=convertList(arr);
        printNode(head);
        map=findPairsLinkedList(head, target);
        System.out.println("After Finding pairs");
        if(map.isEmpty()){
            System.out.println("There are no pairs");
            return;
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.print("["+entry.getKey()+" "+entry.getValue()+"] \n");
        }
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode(int data1) {
        val = data1;
        next = null;
        prev=null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev=prev1;
    }
}
