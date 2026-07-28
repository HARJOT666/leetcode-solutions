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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return findDifference(list);
    }
    private int findDifference(List<Integer> list){
        int min = Integer.MAX_VALUE;
        int n = list.size();
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                min = Math.min(min,Math.abs(list.get(i) - list.get(j)));
            }
        }
        return min;
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left,list);
        int curr = root.val;
        list.add(curr);
        inorder(root.right,list);
    }
}