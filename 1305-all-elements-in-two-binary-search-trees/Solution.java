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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1,list1);
        inorder(root2,list2);
        List<Integer> ans = new ArrayList<>();
        ans.addAll(list1);
        ans.addAll(list2);
        Collections.sort(ans);
        return ans;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        inorder(root.left,list);
        inorder(root.right,list);
    }
}