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
    public int findBottomLeftValue(TreeNode root) {
        int level = 0 ;
        List<Integer> list = new ArrayList<>();
        leftSideView(root,level,list);
        int n = list.size();
        if(n == 0){
            return 0;
        }
        return list.get(n-1);
    }

    public void leftSideView(TreeNode root,int level,List<Integer> list){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }

        leftSideView(root.left,level+1,list);
        leftSideView(root.right,level+1,list);
    }
}