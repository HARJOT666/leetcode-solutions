class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> original = new ArrayList<>();
        inorder(root, original);
        for (int i = 1; i < original.size(); i++) {
            if (original.get(i) <= original.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}