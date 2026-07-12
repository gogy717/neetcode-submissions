class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {

        // Step 1: build freq map
        unordered_map<int, int> freq;
        for (auto n : nums) 
            freq[n] ++;

        // Step 2: min-heap of (count, num)
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> minHeap;

        for (auto& [num, cnt] : freq) {
            minHeap.push({cnt, num});
            if (minHeap.size() > k) 
                minHeap.pop();
        }

        // Step 3: collect result
        vector<int> result;
        while (!minHeap.empty()) {
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }
        return result;
    }
};