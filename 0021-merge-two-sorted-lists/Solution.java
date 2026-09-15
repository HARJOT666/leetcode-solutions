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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        while(list1!=null){
            list.add(list1.val);
            list1 = list1.next;
        }
        while(list2!=null){
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        if(list.isEmpty()){
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;
        for(int i=1;i<list.size();i++){
            current.next = new ListNode(list.get(i));
            current = current.next;
        }
    return head;
    }
}