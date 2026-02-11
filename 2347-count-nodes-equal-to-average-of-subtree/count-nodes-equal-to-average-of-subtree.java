/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int c=0;
    public int averageOfSubtree(TreeNode root) {
       helper(root);
       return c;   
    }
    public int helper(TreeNode root){
        if(root==null)
        return 0;
        int s1=helper(root.left);
        int s2=helper(root.right);
        int s=root.val+s1+s2;
        int n=helper2(root);
        if(s/n==root.val)
        c++;
        return s;
    }
    public int helper2(TreeNode root){
        if(root==null)
        return 0;
        int n1=helper2(root.left);
        int n2=helper2(root.right);
        return n1+n2+1;
    }
}