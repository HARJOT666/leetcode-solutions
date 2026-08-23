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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res ={0} ;
        solve(root,res);
        return res[0]-1;
    }
    int solve(TreeNode root,int[] res){
        if(root ==null){
            return 0;
        }
        int l = solve(root.left,res);
        int r = solve(root.right,res);
        int temp = Math.max(l,r) + 1;
        int ans = Math.max(temp,l+r+1);
        res[0] = Math.max(res[0], ans);
        return temp;
    }
}