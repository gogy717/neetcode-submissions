class Solution {
    private boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }

        return a.val == b.val
            && isSameTree(a.left, b.left)
            && isSameTree(a.right, b.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return isSameTree(root, subRoot)
            || isSubtree(root.left, subRoot)
            || isSubtree(root.right, subRoot);
    }
}