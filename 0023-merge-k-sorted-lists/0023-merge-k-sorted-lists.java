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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        int n=lists.length;
        for(int i=0;i<n;i++){
            ListNode curr=lists[i];
            while(curr!=null){
                pq.add(curr);
                curr=curr.next;
            }
        }
        ListNode res=new ListNode(0);
        ListNode dummy=res;
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            dummy.next=node;
            dummy=dummy.next;
        }
        dummy.next=null;// to prevent from cycle
        return res.next;
    }
}