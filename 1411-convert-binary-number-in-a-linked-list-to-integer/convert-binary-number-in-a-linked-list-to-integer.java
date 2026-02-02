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
    public int getDecimalValue(ListNode head) {
        int val=0;
       ListNode temp=head;int c=0;
       String str="";
        while(temp!=null){
            str=temp.val+str;
            temp=temp.next;
        }
        for(int i=0;i<str.length();i++){
            val+=(int)Math.pow(2,c++)*(str.charAt(i)=='1'?1:0);
        }
        return val;
    }
}