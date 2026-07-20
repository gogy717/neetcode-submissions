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
    vector<int> result;
    void inorder_traversal(TreeNode* root, vector<int>& result){
        if (root == nullptr) return;
            inorder_traversal(root->left, result);   // 先左
            result.push_back(root->val);   // 再访问自己
            inorder_traversal(root->right, result);  // 最后右
    }
public:
    int kthSmallest(TreeNode* root, int k) {
        inorder_traversal(root, result);
        return result[k - 1];


    }
};
