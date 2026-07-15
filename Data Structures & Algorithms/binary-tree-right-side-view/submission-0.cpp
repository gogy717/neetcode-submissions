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
    vector<int> rightSideView(TreeNode* root) {
        if (root == nullptr) {
            return {};
        }
        queue<TreeNode*> q;
        q.push(root);
        
        vector<vector<int>> result;
        // result.push_back({root->val});

        while (!q.empty()) {

            int num = q.size();

            vector<int> temp;
            for(int i = 0; i < num; i ++) {
                if (q.front()->left != nullptr)
                    q.push(q.front()->left);
                if (q.front()->right != nullptr)
                    q.push(q.front()->right);
                temp.push_back(q.front()->val);
                q.pop();
            }
            result.push_back(temp);
        }
        vector<int> rightSide;
        for (vector<int> r: result) {
            rightSide.push_back(r.back());
        }
        return rightSide;
    }
};
