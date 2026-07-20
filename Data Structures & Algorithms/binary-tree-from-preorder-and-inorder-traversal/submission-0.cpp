class Solution {
public:
    unordered_map<int, int> idxMap;  // 值 -> 中序遍历中的下标
    vector<int> preorder;

    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        this->preorder = preorder;
        for (int i = 0; i < inorder.size(); i++) {
            idxMap[inorder[i]] = i;
        }
        return build(0, preorder.size() - 1, 0, inorder.size() - 1);
    }

    // preLeft, preRight: 当前子树在 preorder 中的范围
    // inLeft, inRight: 当前子树在 inorder 中的范围
    TreeNode* build(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return nullptr;  // 空树 (empty tree)

        int rootVal = preorder[preLeft];         // 先序第一个是根
        TreeNode* root = new TreeNode(rootVal);

        int rootIdx = idxMap[rootVal];            // 根在中序里的位置
        int leftSize = rootIdx - inLeft;           // 左子树的节点个数

        // 递归构造左子树
        root->left = build(preLeft + 1, preLeft + leftSize, inLeft, rootIdx - 1);
        // 递归构造右子树
        root->right = build(preLeft + leftSize + 1, preRight, rootIdx + 1, inRight);

        return root;
    }
};