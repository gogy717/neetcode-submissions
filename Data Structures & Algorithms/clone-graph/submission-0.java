/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Node, Node> cloned = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return dfs(node);
    }

    private Node dfs(Node original) {
        // 如果这个原节点以前复制过，直接使用已有副本
        if (cloned.containsKey(original)) {
            return cloned.get(original);
        }

        // 创建当前节点的副本
        Node copy = new Node(original.val);

        // 必须先记录，再访问邻居，避免遇到环时无限递归
        cloned.put(original, copy);

        for (Node neighbor : original.neighbors) {
            // 递归复制邻居，并把邻居的副本连接到 copy
            copy.neighbors.add(dfs(neighbor));
        }

        return copy;
    }
}