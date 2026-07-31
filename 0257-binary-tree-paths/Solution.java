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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String path  = "";
        find(root,list,path);
        return list;
    }
    public void find(TreeNode root,List<String> list,String path){
        if(root == null){
            return ;
        }
            if(root.left == null && root.right == null) {//leaf node
                //add the path to the list
                path += root.val;
                list.add(path);
                
                //empty the list and start again
            }
            else{
                path += root.val + "->";
                find(root.left,list,path);
                find(root.right,list,path);
            }
        
    }
    //Ill use dfs obviously
}