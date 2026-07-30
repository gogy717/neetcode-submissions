class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        // maxHeap of 2 elements tops
        priority_queue<int> pq;
        for (int stone : stones) {
            pq.push(stone);
        }
        while (pq.size() > 1) {
            int top = pq.top();
            pq.pop();
            if (pq.top() == top) {
                pq.pop();
            } else {
                int second = pq.top();
                pq.pop();
                pq.push(top - second);
            }
        }
        return pq.empty() ? 0 : pq.top();
    }
};
