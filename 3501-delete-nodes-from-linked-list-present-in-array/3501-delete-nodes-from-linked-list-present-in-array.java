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
    public ListNode modifiedList(int[] nums, ListNode temp) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        ListNode res=new ListNode(-1);
        ListNode dummy=res;
        ListNode head=temp;
        while(head!=null){
            int data=head.val;
            if(!set.contains(data)){
                dummy.next=head;
                dummy=dummy.next;
            }
            head=head.next;
        }
        dummy.next=null;
        return res.next;
    }
}