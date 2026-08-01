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
    public int findTilt(TreeNode root) {
        //tile is the difference between the sum of the leftsubrtree and the right subtree
       List<Integer> list = new ArrayList<>();
       sum(root,list);
       int sum = 0;
       for (int x : list) {
            sum += x;
        }
        return sum;

    }
    private int sum(TreeNode root,List<Integer> list){
        if(root == null){
            return 0;
        }
        //recursion concept is needed here
       int leftTree =  sum(root.left,list);//sum of the left subtree
       int rightTree = sum(root.right,list);//sum of the right subtree
       int tilt = Math.abs(leftTree - rightTree);
       list.add(tilt);
        return leftTree + rightTree + root.val;
    }
}