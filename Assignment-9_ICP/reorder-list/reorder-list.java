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
    public void reorderList(ListNode head) {
       List<ListNode>l1=new ArrayList<>();
       ListNode temp=head;
       while(temp!=null){
        l1.add(temp);
        temp=temp.next;
       } 
       int n=l1.size();
       for(int i=0;i<l1.size()/2;i++){
           l1.get(i).next=l1.get(n-1-i);
           l1.get(n-1-i).next=l1.get(i+1);
       }
       l1.get(n/2).next=null;
    }
}
/*
tc-o(n)
sc-o(n)
    */
