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
    int cnt = 0;
    void dfs(TreeNode* node, int maxVal) {
        if (node == nullptr) {
            return;
        }
        if (node->val >= maxVal) {
            cnt++;
            maxVal = node->val;
        }
        dfs(node->left, maxVal);
        dfs(node->right, maxVal);
    }
public:
    int goodNodes(TreeNode* root) {
        dfs(root, INT_MIN);
        return cnt;
    }
};
