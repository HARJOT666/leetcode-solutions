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
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
       if(list.isEmpty()){
            return null;
        }
        ListNode newHead = new ListNode(list.get(0));
        ListNode current = newHead;
        for(int i=1;i<list.size();i++){
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
        return newHead;
    }
}