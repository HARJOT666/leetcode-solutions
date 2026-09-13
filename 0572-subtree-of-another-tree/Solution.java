class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        preorder(root, list1);
        preorder(subRoot, list2);

        return containsSubList(list1, list2);
    }

   public boolean containsSubList(List<Integer> list1, List<Integer> list2) {

    if (list2.size() > list1.size()) {
        return false;
    }

    for (int i = 0; i <= list1.size() - list2.size(); i++) {

        int count = 0;

        for (int j = 0; j < list2.size(); j++) {

            if (list1.get(i + j) == null && list2.get(j) == null) {
                count++;
            }
            else if (list1.get(i + j) != null &&
                     list1.get(i + j).equals(list2.get(j))) {
                count++;
            }
            else {
                break;
            }
        }

        if (count == list2.size()) {
            return true;
        }
    }

    return false;
}

    private void preorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);

        preorder(root.left, list);
        preorder(root.right, list);
    }
}