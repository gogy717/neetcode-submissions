class Solution {

public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        struct cmp {
            bool operator() (const vector<int>& a, const vector<int>& b) {
                long long distA = (long long)a[0] * a[0] + (long long)a[1] * a[1];
                long long distB = (long long)b[0] * b[0] + (long long)b[1] * b[1];
                // return distA > distB; // 小顶堆:距离小的在堆顶
                return distA < distB; // 大顶堆:距离大的在堆顶
        };

        };
        priority_queue<vector<int>, vector<vector<int>>, cmp> pq;
        for (vector<int> point : points) {
            pq.push(point);
            if (pq.size() > k) {
                pq.pop();
            }
        }
        vector<vector<int>> result;
        while (! pq.empty()) {
            result.push_back(pq.top());
            pq.pop();
        }
        return result;
    }
};
