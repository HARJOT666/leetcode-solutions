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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            int size = q.size();
            while(size > 0){
                TreeNode curr = q.poll();
                list1.add(curr.val);
                if(curr.left != null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
                size--;
            }
            list.add(list1);
        }
        return list;
    }
}