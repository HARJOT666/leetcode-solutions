class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int num : nums)
            list.add(num);

        return build(list);
    }

    private TreeNode build(List<Integer> list) {
        if (list.size() == 0)
            return null;
        int rootValue = findMax(list);
        TreeNode root = new TreeNode(rootValue);
        int index = list.indexOf(rootValue);
        List<Integer> left = list.subList(0, index);
        List<Integer> right = list.subList(index + 1, list.size());
        root.left = build(left);
        root.right = build(right);
        return root;
    }

    private int findMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int num : list)
            max = Math.max(max, num);
        return max;
    }
}