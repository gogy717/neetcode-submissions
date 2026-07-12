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
public:
    int maxDepth(TreeNode* root) {
        TreeNode* thisNode = root;
        if (thisNode == nullptr) {
            return 0;
        }
        int max_depth = 1;
        max_depth += max(maxDepth(thisNode->left), maxDepth(thisNode->right));
        return max_depth;
    }
};
