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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        Collections.sort(list);
        TreeNode root1 = null;
    for (int val : list) {
        root1 = insert(root1, val);
    }
    return root1;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        
            list.add(root.val);
            inorder(root.left,list);
            inorder(root.right,list);
        
    }
   public TreeNode insert(TreeNode root, int val) {
    if (root == null) {
        return new TreeNode(val);
    }

    if (val < root.val) {
        root.left = insert(root.left, val);
    } else {
        root.right = insert(root.right, val);
    }

    return root;
}
}