class Solution {
private:
    bool validate(TreeNode* node, TreeNode* lower, TreeNode* upper) {
        if (node == nullptr) return true;
        
        if (lower != nullptr && node->val <= lower->val) return false;
        if (upper != nullptr && node->val >= upper->val) return false;
        
        return validate(node->left, lower, node) 
            && validate(node->right, node, upper);
    }
public:
    bool isValidBST(TreeNode* root) {
        return validate(root, nullptr, nullptr);
    }
};