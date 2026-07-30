class KthLargest {
private:
    int k;
    // maxHeap
    // priority_queue<int> pq;
    // minHeap
    priority_queue<int, vector<int>, greater<int>> pq;

public:
    KthLargest(int k, vector<int>& nums) {
        this -> k = k;
        this -> pq = priority_queue<int, vector<int>, greater<int>>();

        for (int n : nums) {
            pq.push(n);

            if (pq.size() > k) {
                pq.pop();
            }
        }

    }
    
    int add(int val) {
        this -> pq.push(val);
        if (pq.size() > k) {
            pq.pop();
        }
        int result = pq.top();

        return result;
    }
};
