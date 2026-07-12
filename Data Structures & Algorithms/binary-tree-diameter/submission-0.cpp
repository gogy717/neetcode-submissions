/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
private:
    int maxDiameter = 0;
    int maxDepth(TreeNode* node) {
        if (!node) {
            return 0;
        }
        int leftDepth = maxDepth(node->left);
        int rightDepth = maxDepth(node->right);
        
        maxDiameter = max(maxDiameter, leftDepth+ rightDepth);
        return 1 + max(leftDepth, rightDepth);
    }
public:
    int diameterOfBinaryTree(TreeNode* root) {
        // maxDepth of left and right's sum
        maxDepth(root);
        return maxDiameter;
        
    }
};
