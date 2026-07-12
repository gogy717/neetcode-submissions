/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right)
 *         : val(x), left(left), right(right) {}
 * };
 */

class Solution {
private:
    // 返回树的高度；如果树不平衡，则返回 -1
    int getHeight(TreeNode* root) {
        if (root == nullptr) {
            return 0;
        }

        int leftHeight = getHeight(root->left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = getHeight(root->right);
        if (rightHeight == -1) {
            return -1;
        }

        if (abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return max(leftHeight, rightHeight) + 1;
    }

public:
    bool isBalanced(TreeNode* root) {
        return getHeight(root) != -1;
    }
};