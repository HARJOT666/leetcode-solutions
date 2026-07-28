class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        // store node with its height
        Map<Integer, Integer> map = new HashMap<>();

        boolean[] ans = {true};
        int height = 0;

        find(root, x, y, map, height, ans);

        // x and y are siblings
        if (!ans[0]) {
            return false;
        }

        int height1 = map.get(x);
        int height2 = map.get(y);

        if (height1 == height2) {
            return true;
        }

        return false;
    }

    public void find(TreeNode root, int x, int y,
                     Map<Integer, Integer> map,
                     int height, boolean[] ans) {

        if (root == null) {
            return;
        }

        // store x/y and their corresponding height
        if (root.val == x || root.val == y) {
            map.put(root.val, height);
        }

        // check whether x and y have the SAME parent
        if (root.left != null && root.right != null) {

            if ((root.left.val == x && root.right.val == y) ||
                (root.left.val == y && root.right.val == x)) {

                ans[0] = false;
            }
        }

        find(root.left, x, y, map, height + 1, ans);
        find(root.right, x, y, map, height + 1, ans);
    }
}