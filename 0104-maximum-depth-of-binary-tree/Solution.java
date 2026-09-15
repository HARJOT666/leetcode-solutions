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
    public int maxDepth(TreeNode root) {
        return lode(root,0);
    }
    public int lode(TreeNode root,int max){
        if(root == null){
            return max;
        }
        int left = 1 + lode(root.left,max);
        int right = 1+lode(root.right,max);
        max = Math.max(left,right);
        return max;
    }
}