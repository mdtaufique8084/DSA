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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int idx=0;
        while(temp!=null){
            idx++;
            temp=temp.next;
        }
        temp=head;
        if(idx-n==0){
            return head.next;
        }
        for(int i=0;i<idx-n-1;i++){
            temp=temp.next;
        }
        if(temp.next==null){
            return null;
        }
        if(temp.next!=null){
            temp.next=temp.next.next;
        }
        return head;
    }
}