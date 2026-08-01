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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //preorder with null should work
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preorder(root,list1);
        preorder(subRoot,list2);
        return containsSubList(list1,list2);


    }
    public static <T> boolean containsSubList(List<T> list1, List<T> list2) {
    if (list2.size() > list1.size()) return false;

    for (int i = 0; i <= list1.size() - list2.size(); i++) {
        if (list1.subList(i, i + list2.size()).equals(list2)) {
            return true;
        }
    }
    return false;
}
    private void preorder(TreeNode root,List<Integer> list){
        if(root == null){
            list.add(null);
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
       
        preorder(root.right,list);
    }
}